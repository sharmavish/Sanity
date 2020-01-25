// Download ZAP Scanner.
def zapscanner = "wget  -q https://github.com/zaproxy/zaproxy/releases/download/v2.9.0/ZAP_2.9.0_Linux.tar.gz"
def zap = zapscanner.execute()
zap.waitFor()              
println "sonar Process exit code: ${zap.exitValue()}"

// Unzip the sonar zip
def scanner = new AntBuilder()   
scanner.unzip(  src:"sonar-scanner-cli-3.3.0.1492.zip",
            dest:"./",
            overwrite:"false" )


// Delete the ZAP and sonar scanner zip files 

def sonararchive = new File('sonar-scanner-cli-3.3.0.1492.zip')
sonararchive.delete()

def sonarfile = new File('sonar-scanner-3.3.0.1492')
sonarfile.renameTo( new File('sonar') )

def cmd = "sudo pip install zapcli && sudo chmod -R 777 ./"
def cmdproc = cmd.execute()
cmdproc.waitFor()              
println "Perm Process exit code: ${cmdproc.exitValue()}"
