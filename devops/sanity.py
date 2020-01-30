# sudo sed -i "s|projectname|$PROJECT_NAME|g;s|projectid|$PROJECT_ID|g;s|datasetname|$DATEAET_NAME|g" sanity.json 
#!/usr/bin/env python
import os
import subprocess
PROJECT = os.environ['PROJECT_NAME']
ID = os.environ['PROJECT_ID']
DATESET = os.environ['DATEAET_NAME']
subprocess.call(["sudo sed -i "s|projectname|$PROJECT|g;s|projectid|$ID|g;s|datasetname|$DATEAET|g" sanity.json"], shell=True)
