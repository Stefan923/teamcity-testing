# Robot Framework attachment-pattern fixture

`tests/com.example.robot/RobotMappingTest/mapping.robot` contains 20 Robot test cases and produces `results/output.xml`, the native Robot result. Evidence uses `evidence/robot/<package>/<class>/<test>/...`; the workflow prints matches with `robot/{package}/{class}/{test}/*`. Robot has no native package/class fields, so the nested suite directory convention supplies them.

Run `pip install robotframework`, `robot --outputdir results tests`, and `python3 tools/map_attachments.py --root evidence --pattern 'robot/{package}/{class}/{test}/*' --xml results/output.xml`. The mapper parses nested Robot suites and prints `XML_TESTCASE=FOUND` only when package, class, and test match an actual XML entry.

For Copilot: preserve the suite and test path segments when adding evidence, and keep any filename normalization explicit.