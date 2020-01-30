#!/usr/bin/env groovy 
#def PROJECT_NAME = System.getenv("PROJECT_NAME")
#def PROJECT_ID = System.getenv("PROJECT_ID")
#def DATEAET_NAME = System.getenv("DATEAET_NAME")
def file = new File('sanity.json')
def newConfig = file.text.replace('projectname', '${PROJECT_NAME}')
file.text = newConfig
