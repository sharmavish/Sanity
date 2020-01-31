#!/usr/bin/env python
import os
fin = open("sanity.json", "rt")
data = fin.read()
data = data.replace('projectname', os.getenv('PROJECT_NAME'))
data = data.replace('projectid', os.getenv('PROJECT_ID'))
data = data.replace('datasetname', os.getenv('DATEAET_NAME'))
fin.close()

fin = open("sanity.json", "wt")
fin.write(data)
fin.close()
