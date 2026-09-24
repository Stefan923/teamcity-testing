param(
    [ValidateRange(1, [int]::MaxValue)]
    [int]$Count = 1000,

    [string]$MessagePrefix = "Generated commit",

    [string]$File = "generated-commits.txt",

    [string]$Remote = "origin"
)

$ErrorActionPreference = "Stop"
$repositoryRoot = Split-Path -Parent $PSScriptRoot

function Invoke-Git {
    param([string[]]$Arguments)

    $output = & git -C $repositoryRoot @Arguments
    if ($LASTEXITCODE -ne 0) {
        throw "git $($Arguments -join ' ') failed with exit code $LASTEXITCODE"
    }
    return $output
}

$repositoryPath = [System.IO.Path]::GetFullPath($repositoryRoot)
$outputPath = [System.IO.Path]::GetFullPath((Join-Path $repositoryRoot $File))
if (-not $outputPath.StartsWith($repositoryPath + [System.IO.Path]::DirectorySeparatorChar)) {
    throw "File must be inside the repository"
}

$branch = (Invoke-Git -Arguments @("branch", "--show-current")) -join ""
if ([string]::IsNullOrWhiteSpace($branch)) {
    throw "Cannot run from a detached HEAD"
}

$existingFileChanges = Invoke-Git -Arguments @("status", "--porcelain", "--", $File)
if ($existingFileChanges) {
    throw "$File already has uncommitted changes"
}

$outputDirectory = Split-Path -Parent $outputPath
if (-not (Test-Path $outputDirectory)) {
    New-Item -ItemType Directory -Path $outputDirectory | Out-Null
}

Write-Host "Creating $Count commits on $branch..."
for ($commitNumber = 1; $commitNumber -le $Count; $commitNumber++) {
    $timestamp = [DateTime]::UtcNow.ToString("o")
    Add-Content -Path $outputPath -Value "$commitNumber`t$timestamp" -Encoding UTF8

    Invoke-Git -Arguments @("add", "--", $File) | Out-Null
    Invoke-Git -Arguments @(
        "commit",
        "--only",
        "-m",
        "$MessagePrefix $commitNumber/$Count",
        "--",
        $File
    ) | Out-Null
    Write-Host "[$commitNumber/$Count] committed"
}

Write-Host "Pushing $branch to $Remote..."
Invoke-Git -Arguments @("push", $Remote, $branch) | Out-Host
Write-Host "Done."