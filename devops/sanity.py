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
path = "/home/runner/.config/sanity"
os.makedirs( path, 0777 );
os.system('cp -p ./devops/config.json /home/runner/.config/sanity/')
con = open("/home/runner/.config/sanity/config.json", "rt")
sanitydata = con.read()
sanitydata= sanitydata.replace('SANITY_AUTH_TOKEN', os.getenv('SANITY_AUTH_TOKEN'))
con.close()
con = open("/home/runner/.config/sanity/config.json", "wt")
con.write(sanitydata)
con.close()

