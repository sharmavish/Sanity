#!/usr/bin/env groovy 
def PROJECT_NAME = Syetm.getenv("PROJECT_NAME")
def PROJECT_ID = Syetm.getenv("PROJECT_ID")
def DATEAET_NAME = Syetm.getenv("DATEAET_NAME")
def sedcmd = "sudo sed -i \"s|projectname|$PROJECT_NAME|g;s|projectid|$PROJECT_ID|g;s|datasetname|$DATEAET_NAME|g\" sanity.json"
def sedcmdproc = sedcmd.execute()           
sedcmdproc.waitFor()
println "apt Process exit code: ${sedcmdproc.exitValue()}"
println "Std Err apt : ${sedcmdproc.err.text}"

