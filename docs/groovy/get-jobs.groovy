// This will get all jobs recursively whether at the root of Jnkeins, in a folder or an in organisation folder

for(job in Hudson.instance.getAllItems(org.jenkinsci.plugins.workflow.job.WorkflowJob)) {
  println(job.fullName)
}
