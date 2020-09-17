#!/usr/bin/env groovy

/*
  This will get all jobs recursively whether at the root of Jenkins, in a folder, in an 
  organisation folder or at the root
*/

// 

for(job in Hudson.instance.getAllItems(org.jenkinsci.plugins.workflow.job.WorkflowJob)) {
  println(job.fullName)
}

/*
  Cancel all jobs in the queue which contain a defined string in their name (it's a like statement).
  it =~ /dependabot/ matches to *dependabot*
  
*/

import hudson.model.*

def q = Jenkins.instance.queue

q.items.each { 
  if (it =~ /dependabot/) {
	q.cancel(it.task)
  }
}
