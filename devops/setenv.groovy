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


new File(System.getenv("GITHUB_WORKSPACE")).withOutputStream { out ->
    new URL('https://binaries.sonarsource.com/Distribution/sonar-scanner-cli/sonar-scanner-cli-3.3.0.1492.zip').eachByte { soanrout ->
        out.write(sonarout)
    }

