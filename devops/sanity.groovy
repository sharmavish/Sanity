#!/usr/bin/env groovy
 def project = System.getenv("PROJECT_NAME")
 def file = new File('./sanity.json')
 def newConfig = file.text.replace('projectname', 'project')
 file.text = newConfig
