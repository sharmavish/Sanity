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


// Download ZAP Scanner.
def zapscanner = "wget  -q https://github.com/zaproxy/zaproxy/releases/download/v2.9.0/ZAP_2.9.0_Linux.tar.gz"
def zap = zapscanner.execute()
zap.waitFor()              
println "sonar Process exit code: ${zap.exitValue()}"

// Unarchive the ZAP proxy 
def zapproxy = new AntBuilder()   
zapproxy.untar(  src:"ZAP_2.9.0_Linux.tar.gz",
            dest:"./",
            compression:"gzip",
            overwrite:"false" )



 def zapgz = new File('ZAP_2.9.0_Linux.tar.gz')  
 zapgz.delete()
  
// Rename the ZAP and sonar-scanner
def zapfile = new File('./ZAP_2.9.0')
zapfile.renameTo( new File('./zap') )



