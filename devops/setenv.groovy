// Install required packages.

def aptcmd = "sudo apt install nodejs openjdk-8-jre unzip"
def npmcmd = "sudo npm install -g @sanity/cli netlify-cli"
def aptproc = aptcmd.execute()
def npmproc = npmcmd.execute()
aptproc.waitFor()              
npmproc.waitFor()
println "apt Process exit code: ${aptproc.exitValue()}"
println "npm Process exit code: ${npmproc.exitValue()}"
println "Std Err apt : ${aptproc.err.text}"
println "Std Out apt : ${aptproc.in.text}" 
println "Std Err npm: ${npmproc.err.text}"
println "Std Out npm: ${npmproc.in.text}" 

// Download Sonar scanner.
def sonarscanner = "wget  -q https://binaries.sonarsource.com/Distribution/sonar-scanner-cli/sonar-scanner-cli-3.3.0.1492.zip"
def sonar = sonarscanner.execute()
sonar.waitFor()              
println "sonar Process exit code: ${sonar.exitValue()}"

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

// Unarchive the ZAP proxy 
def zapproxy = new AntBuilder()   
zapproxy.untar(  src:"ZAP_2.9.0_Linux.tar.gz",
            dest:"./",
            compression:"gzip",
            overwrite:"false" )

// Delete the ZAP and sonar scanner zip files 

 def sonararchive = new File('sonar-scanner-cli-3.3.0.1492.zip')
 sonararchive.delete()

 def zapgz = new File('ZAP_2.9.0_Linux.tar.gz')  
 zapgz.delete()
  
// Rename the ZAP and sonar-scanner
def zapfile = new File('./ZAP_2.9.0')
zapfile.renameTo( new File('./zap') )

def sonarfile = new File('sonar-scanner-3.3.0.1492')
sonarfile.renameTo( new File('sonar') )

def perm = "sudo pip install zapcli && sudo chmod -R 777 sonar ."
def permproc = perm.execute()
permproc.waitFor()              
println "Perm Process exit code: ${permproc.exitValue()}"

