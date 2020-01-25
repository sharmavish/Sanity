def command = "sudo apt update && sudo apt install nodejs openjdk-8-jre unzip && sudo npm install \-g @sanity\/cli netlify-cli"
def proc = command.execute()
proc.waitFor()              

println "Process exit code: ${proc.exitValue()}"
println "Std Err: ${proc.err.text}"
println "Std Out: ${proc.in.text}"
