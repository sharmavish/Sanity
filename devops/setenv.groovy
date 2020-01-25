// Install required packages.

def command = "sudo apt install nodejs openjdk-8-jre unzip"
def command1 = "sudo npm install -g @sanity/cli netlify-cli"
def proc = command.execute()
def proc1 = command1.execute()
proc.waitFor()              
proc1.waitFor()
println "Process exit code command: ${proc.exitValue()}"
println "Process exit code command1: ${proc1.exitValue()}"
println "Std Err command : ${proc.err.text}"
println "Std Out command : ${proc.in.text}" 
println "Std Err command1: ${proc1.err.text}"
println "Std Out command1: ${proc1.in.text}" 

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
def ant = new AntBuilder()   
ant.untar(  src:"ZAP_2.9.0_Linux.tar.gz",
            dest:"./",
            overwrite:"false" )

// - >*
// && rm -rf sonar-scanner-cli-3.3.0.1492.zip && sudo mv sonar-scanner-3.3.0.1492 sonar \
// && sudo chmod -R 777 sonar ${GITHUB_WORKSPACE}

// ## Install zap
 // wget -q https://github.com/zaproxy/zaproxy/releases/download/v2.9.0/ZAP_2.9.0_Linux.tar.gz > /dev/null \
// && sudo pip install zapcli \
// && sudo tar xzf ZAP_2.9.0_Linux.tar.gz > /dev/null && sudo mv ZAP_2.9.0 zap \
// && sudo rm -rf ZAP_2.9.0_Linux.tar.gz 

// 
