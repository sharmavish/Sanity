# sudo sed -i "s|projectname|$PROJECT_NAME|g;s|projectid|$PROJECT_ID|g;s|datasetname|$DATEAET_NAME|g" sanity.json 
#!/usr/bin/env python
import os
os.system("sudo sed -i "s|projectname|os.getenv(\'PROJECT_NAME\')|g;s|projectid|os.getenv(\'PROJECT_ID\')|g;s|datasetname|os.getenv(\'DATEAET_NAME\')|g" sanity.json")
