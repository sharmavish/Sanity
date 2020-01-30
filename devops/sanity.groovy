#!/usr/bin/env groovy 
def sedcmd = "sudo sed -i 's|projectname|System.getenv\(\"PROJECT_NAME\"\)|g;s|projectid|System.getenv\(\"PROJECT_ID\")\|g;s|datasetname|System.getenv\("\DATEAET_NAME\"\)|g' sanity.json"
def sedcmdproc = sedcmd.execute()           
sedcmdproc.waitFor()
println "apt Process exit code: ${sedcmdproc.exitValue()}"
println "Std Err apt : ${sedcmdproc.err.text}"

