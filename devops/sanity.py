#!/usr/bin/env python
import os, sys
fin = open("sanity.json", "rt")
data = fin.read()
data = data.replace('projectname', os.getenv('PROJECT_NAME'))
data = data.replace('projectid', os.getenv('PROJECT_ID'))
data = data.replace('datasetname', os.getenv('DATEAET_NAME'))
fin.close()

fin = open("sanity.json", "wt")
fin.write(data)
fin.close()

###### FOR Auth token ####
con = open("./devops/config.json", "rt")
sanitydata = con.read()
sanitydata= sanitydata.replace('SANITY_AUTH_TOKEN', os.getenv('SANITY_AUTH_TOKEN'))
con.close()
con = open("./devops/config.json", "wt")
con.write(sanitydata)
con.close()

os.system('sudo mkdir -p /home/runner/.config/sanity')
os.system('sudo cp -p ./devops/config.json /home/runner/.config/sanity/')



