#!/usr/bin/env groovy 
def env = System.getenv()
def sedcmd = sudo sed -i "s|projectname|env['PROJECT_NAME']|g;s|projectid|env['PROJECT_ID']|g;s|datasetname|env['DATEAET_NAME']|g" sanity.json
def sedcmdproc = sedcmd.execute()           
sedcmdproc.waitFor()
println "apt Process exit code: ${sedcmdproc.exitValue()}"
println "Std Err apt : ${sedcmdproc.err.text}"

