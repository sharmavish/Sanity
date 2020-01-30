#!/usr/bin/env groovy 
 def env = System.getenv()
// def PROJECT_ID = System.getenv("PROJECT_ID")
// def DATEAET_NAME = System.getenv("DATEAET_NAME")
def file = new File('sanity.json')
def newConfig = file.text.replace('projectname', env["PROJECT_NAME"])
file.text = newConfig
