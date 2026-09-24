import argparse
import re
import xml.etree.ElementTree as ElementTree
from pathlib import Path


def read_testcases(xml_path):
    testcases = set()

    def visit_suite(suite, parents):
        suite_name = suite.get('name', '')
        suite_path = parents + [suite_name] if suite_name else parents
        for test in suite.findall('test'):
            if len(suite_path) >= 3:
                package_source = suite.get('source', '').replace('\\', '/').rstrip('/').split('/')[-3]
                testcases.add((package_source, suite_path[-2], test.get('name', '')))
        for child in suite.findall('suite'):
            visit_suite(child, suite_path)

    root = ElementTree.parse(xml_path).getroot()
    for suite in root.findall('suite'):
        visit_suite(suite, [])
    return testcases

def main():
    parser = argparse.ArgumentParser()
    parser.add_argument('--root', default='.')
    parser.add_argument('--pattern', required=True)
    parser.add_argument('--xml', required=True)
    args = parser.parse_args()
    fields = {'package': r'[\w.]+', 'class': r'[\w$]+', 'test': r'[^/]+?', 'suite': r'[^/]+?'}
    expression = ''
    index = 0
    while index < len(args.pattern):
        if args.pattern.startswith('**', index): expression += '.*'; index += 2
        elif args.pattern[index] == '*': expression += '[^/]*'; index += 1
        elif args.pattern[index] == '{':
            end = args.pattern.find('}', index)
            if end < 0 or args.pattern[index + 1:end] not in fields: raise ValueError('invalid placeholder')
            name = args.pattern[index + 1:end]; expression += f'(?P<{name}>{fields[name]})'; index = end + 1
        else: expression += re.escape(args.pattern[index]); index += 1
    matcher = re.compile(f'^{expression}$')
    testcases = read_testcases(args.xml)
    root = Path(args.root)
    print(f'ATTACHMENTS_PATTERN={args.pattern}')
    matches = 0
    for path in sorted(p for p in root.rglob('*') if p.is_file()):
        relative = path.relative_to(root).as_posix()
        match = matcher.match(relative)
        if match:
            values = match.groupdict()
            identity = (values.get('package', ''), values.get('class', ''), values.get('test', ''))
            state = 'FOUND' if identity in testcases else 'MISSING'
            print(f"MATCH {relative} -> package={identity[0]} class={identity[1]} test={identity[2]} XML_TESTCASE={state}")
            matches += 1
        else: print(f'IGNORED {relative}')
    print(f'MATCHED_FILES={matches}')

if __name__ == '__main__': main()