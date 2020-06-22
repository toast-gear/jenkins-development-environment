MAX_BUILDS = 40

def jobsList = []
for(job in Hudson.instance.getAllItems(org.jenkinsci.plugins.workflow.job.WorkflowJob)) {
  if(job.fullName =~ /my-jenkins-job-name/)
  {
    //println("Adding job: " + job.fullName)
    jobsList.add(job)
  }
}

for (i = 0; i <5; i++) {
  for (job in jobsList) {
    def recent = job.builds.limit(MAX_BUILDS)
    for (build in job.builds) {
      if (!recent.contains(build)) {
        println ""
        println "========================================================="
        println "Preparing to delete: " + build
        //build.delete()
        println ""
      }
    }
  }
}
