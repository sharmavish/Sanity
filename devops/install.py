#!/usr/bin/env python
import os
from envs import env
from urllib.request import urlopen
from zipfile import ZipFile

os.system("sudo apt update && sudo apt install nodejs openjdk-8-jre && sudo npm install -g @sanity/cli netlify-cli")
zipurl = 'https://binaries.sonarsource.com/Distribution/sonar-scanner-cli/sonar-scanner-cli-3.3.0.1492.zip'
zipresp = urlopen(zipurl)
tempzip = open(sonar-scanner-cli-3.3.0.1492.zip", "wb")
tempzip.write(zipresp.read())
tempzip.close()
zf = ZipFile("sonar-scanner-cli-3.3.0.1492.zip")
zf.extractall(path = '<extraction_path>')
zf.close()
               


