#!/usr/bin/env python
import os
import zipfile, urllib.request, shutil
from envs import env
os.system("sudo apt update && sudo apt install nodejs openjdk-8-jre && sudo npm install -g @sanity/cli netlify-cli")



url = 'https://binaries.sonarsource.com/Distribution/sonar-scanner-cli/sonar-scanner-cli-3.3.0.1492.zip'
file_name = 'sonar-scanner-cli-3.3.0.1492.zip'
with urllib.request.urlopen(url) as response, open(file_name, 'wb') as out_file:
    shutil.copyfileobj(response, out_file)
    with zipfile.ZipFile(file_name) as zf:
        zf.extractall("./devops/")


