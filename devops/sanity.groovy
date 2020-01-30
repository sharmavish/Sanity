def cmd = "sudo mkdir -p /home/runner/.config/sanity/"
def proc = cmd.execute()
proc.waitFor()              
println "Process exit code: ${proc.exitValue()}"

def cp = "sudo cp -p devops/config.json /home/runner/.config/sanity/"
def cpproc = cp.execute()
cpproc.waitFor()              
println "Process exit code: ${cpproc.exitValue()}"

String contents = new File( '/home/runner/.config/sanity/config.json' ).getText( 'UTF-8' ) 
contents = contents.replaceAll( 'SANITY_AUTH_TOKEN', ${{ secrets.SANITY_AUTH_TOKEN }} )

