#!/usr/bin/env python
import os
import requests, zipfile, io
from envs import env
os.system("sudo apt update && sudo apt install nodejs openjdk-8-jre && sudo npm install -g @sanity/cli netlify-cli")
url_req = requests.get(https://binaries.sonarsource.com/Distribution/sonar-scanner-cli/sonar-scanner-cli-3.3.0.1492.zip)
zip = zipfile.ZipFile(io.BytesIO(url_req.content))
zip.extractall()


