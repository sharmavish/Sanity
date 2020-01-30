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

os.system("wget -q https://github.com/zaproxy/zaproxy/releases/download/v2.9.0/ZAP_2.9.0_Linux.tar.gz")
my_tar = tarfile.open('ZAP_2.9.0_Linux.tar.gz')
my_tar.extractall('./devops') # specify which folder to extract to
my_tar.close()

os.rename('./devops/ZAP_2.9.0','./devops/zap')
os.rename('./devops/sonar-scanner-3.3.0.1492','./devops/sonar')
os.remove('ZAP_2.9.0_Linux.tar.gz','sonar-scanner-cli-3.3.0.1492.zip')

