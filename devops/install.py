#!/usr/bin/env python
import os
from zipfile import ZipFile
from urllib import urlretrieve
import tarfile
import urllib

os.system("sudo apt update && sudo apt install nodejs openjdk-8-jre && sudo npm install -g @sanity/cli netlify-cli")

filename ='sonar-scanner-cli-3.3.0.1492.zip'
destDir = './devops/' 
theurl = 'https://binaries.sonarsource.com/Distribution/sonar-scanner-cli/sonar-scanner-cli-3.3.0.1492.zip'
name, hdrs = urlretrieve(theurl, filename)
thefile=ZipFile(filename)
thefile.extractall(destDir)
thefile.close()

os.rename('./devops/sonar-scanner-3.3.0.1492','./devops/sonar')

url = 'https://github.com/zaproxy/zaproxy/releases/download/v2.9.0/ZAP_2.9.0_Linux.tar.gz'

file_tmp = urllib.urlretrieve(url, filename=None)[0]
base_name = os.path.basename(url)

file_name, file_extension = os.path.splitext(base_name)
tar = tarfile.open(file_tmp)
tar.extractall(file_name)


