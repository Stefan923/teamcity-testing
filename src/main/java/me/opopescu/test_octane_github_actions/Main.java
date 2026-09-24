package me.opopescu.test_octane_github_actions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Base64;

public class Main {
    public static void main(String[] args) {
        System.out.println("Updating application...");
        System.out.println("Hello world! ");
        test();
    }

    private static void test () {
        String inputString = "PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiPz4KPHByb2pl\nY3QgeG1sbnM9Imh0dHA6Ly9tYXZlbi5hcGFjaGUub3JnL1BPTS80LjAuMCIK\nICAgICAgICAgeG1sbnM6eHNpPSJodHRwOi8vd3d3LnczLm9yZy8yMDAxL1hN\nTFNjaGVtYS1pbnN0YW5jZSIKICAgICAgICAgeHNpOnNjaGVtYUxvY2F0aW9u\nPSJodHRwOi8vbWF2ZW4uYXBhY2hlLm9yZy9QT00vNC4wLjAgaHR0cDovL21h\ndmVuLmFwYWNoZS5vcmcveHNkL21hdmVuLTQuMC4wLnhzZCI+CiAgICA8bW9k\nZWxWZXJzaW9uPjQuMC4wPC9tb2RlbFZlcnNpb24+CgogICAgPGdyb3VwSWQ+\nbWUub3BvcGVzY3U8L2dyb3VwSWQ+CiAgICA8YXJ0aWZhY3RJZD50ZXN0LW9j\ndGFuZS1naXRodWItYWN0aW9uczwvYXJ0aWZhY3RJZD4KICAgIDx2ZXJzaW9u\nPjEuMC1TTkFQU0hPVDwvdmVyc2lvbj4KCiAgICA8cHJvcGVydGllcz4KICAg\nICAgICA8bWF2ZW4uY29tcGlsZXIuc291cmNlPjIxPC9tYXZlbi5jb21waWxl\nci5zb3VyY2U+CiAgICAgICAgPG1hdmVuLmNvbXBpbGVyLnRhcmdldD4yMTwv\nbWF2ZW4uY29tcGlsZXIudGFyZ2V0PgogICAgICAgIDxwcm9qZWN0LmJ1aWxk\nLnNvdXJjZUVuY29kaW5nPlVURi04PC9wcm9qZWN0LmJ1aWxkLnNvdXJjZUVu\nY29kaW5nPgogICAgPC9wcm9wZXJ0aWVzPgogICAgPGRlcGVuZGVuY2llcz4K\nICAgICAgICA8ZGVwZW5kZW5jeT4KICAgICAgICAgICAgPGdyb3VwSWQ+b3Jn\nLmp1bml0Lmp1cGl0ZXI8L2dyb3VwSWQ+CiAgICAgICAgICAgIDxhcnRpZmFj\ndElkPmp1bml0LWp1cGl0ZXItZW5naW5lPC9hcnRpZmFjdElkPgogICAgICAg\nICAgICA8dmVyc2lvbj41LjkuMjwvdmVyc2lvbj4KICAgICAgICAgICAgPHNj\nb3BlPnRlc3Q8L3Njb3BlPgogICAgICAgIDwvZGVwZW5kZW5jeT4KICAgIDwv\nZGVwZW5kZW5jaWVzPgo8L3Byb2plY3Q+\n";
        try(StringReader stringReader = new StringReader(inputString.replaceAll("\n", ""));
            BufferedReader bufferedReader = new BufferedReader(stringReader)) {
            bufferedReader.lines().map(string -> new String(Base64.getDecoder().decode(string))).forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
