#!/usr/bin/env groovy


/*
    Delete all build history outside of defined amount. This is needed as excess build history
    can result in an unresponsive Jenkins instance. This script is recursive and supports GitHib
    org scanners as well as folders.
    
    =~ is knowm as the find operator and uses regex. To escape / use a \ e.g.
    /some-folder/some-job/

*/

MAX_BUILDS = 40

def jobsList = []
for(job in Hudson.instance.getAllItems(org.jenkinsci.plugins.workflow.job.WorkflowJob)) {
  if(job.fullName =~ /my-jenkins-bob/)
  {
    println("Adding job: " + job.fullName)
    jobsList.add(job)
  }
}

for (i = 0; i <5; i++) {
  for (job in jobsList) {
    def recent = job.builds.limit(MAX_BUILDS)
    for (build in job.builds) {
      if (!recent.contains(build)) {
        println "Preparing to delete: " + build
        // build.delete()
      }
    }
  }
}
