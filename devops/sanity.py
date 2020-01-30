# sudo sed -i "s|projectname|$PROJECT_NAME|g;s|projectid|$PROJECT_ID|g;s|datasetname|$DATEAET_NAME|g" sanity.json 
#!/usr/bin/env python
import os
PROJECT = os.environ['PROJECT_NAME']
ID = os.environ['PROJECT_ID']
DATESET = os.environ['DATEAET_NAME']
os.system("sudo sed -i "s|projectname|$PROJECT|g;s|projectid|$ID|g;s|datasetname|$DATEAET|g" sanity.json")
