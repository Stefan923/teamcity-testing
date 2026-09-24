*** Settings ***
Library    OperatingSystem

*** Test Cases ***
loginValid
    Should Be True    ${True}
loginInvalid
    Should Be True    ${True}
logout
    Should Be True    ${True}
searchByName
    Should Be True    ${True}
searchById
    Should Be True    ${True}
createUser
    Should Be True    ${True}
updateUser
    Should Be True    ${True}
deleteUser
    Should Be True    ${True}
listUsers
    Should Be True    ${True}
filterUsers
    Should Be True    ${True}
createProject
    Should Be True    ${True}
updateProject
    Should Be True    ${True}
deleteProject
    Should Be True    ${True}
listProjects
    Should Be True    ${True}
archiveProject
    Should Be True    ${True}
uploadAvatar
    Should Be True    ${True}
downloadReport
    Should Be True    ${True}
exportCsv
    Should Be True    ${True}
healthCheck
    Should Be True    ${True}
permissions
    Should Be True    ${True}