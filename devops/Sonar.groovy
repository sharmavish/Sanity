// Download Sonar scanner.
def sonarscanner = "wget  -q https://binaries.sonarsource.com/Distribution/sonar-scanner-cli/sonar-scanner-cli-3.3.0.1492.zip"
def sonar = sonarscanner.execute()
sonar.waitFor()              
println "sonar Process exit code: ${sonar.exitValue()}"

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
