#!/usr/bin/env groovy 
 def subdir = new File('/home/runner/.config/sanity/')
      subdir.mkdir()
def file = new File("devops/config.json")
def newFile = new File("/home/runner/.config/sanity/")
Files.copy(file.toPath(), newFile.toPath())

def cmd ="sudo sed -i "s|SANITY_AUTH_TOKEN|`echo ${{ secrets.SANITY_AUTH_TOKEN }}`|g" /home/runner/.config/sanity/config.json"
def proc = cmd.execute()
proc.waitFor()
println "Process exit code: ${proc.exitValue()}"

