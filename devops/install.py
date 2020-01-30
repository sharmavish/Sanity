#!/usr/bin/env python
import os
from zipfile import ZipFile
from urllib import urlretrieve
from tempfile import mktemp
os.system("sudo apt update && sudo apt install nodejs openjdk-8-jre && sudo npm install -g @sanity/cli netlify-cli")

filename = mktemp('sonar-scanner-cli-3.3.0.1492.zip')
destDir = mktemp()
theurl = 'https://binaries.sonarsource.com/Distribution/sonar-scanner-cli/sonar-scanner-cli-3.3.0.1492.zip'
name, hdrs = urlretrieve(theurl, filename)
thefile=ZipFile(filename)
thefile.extractall(destDir)
thefile.close()

