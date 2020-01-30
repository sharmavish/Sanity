#!/usr/bin/env groovy 
 def file = new File('./sanity.json')
 def newConfig = file.text.replace('projectname', System.getenv("PROJECT_NAME"))
 file.text = newConfig
