#!/usr/bin/env groovy

/*
    Configure your git config
    Script depends on the following plugins:
    1. git

    https://github.com/jenkinsci/git-plugin
*/

import jenkins.model.*

def instance = Jenkins.getInstance()
def desc = instance.getDescriptor("hudson.plugins.git.GitSCM")

println "Configure git username and email"
desc.setGlobalConfigName("jenkins")
desc.setGlobalConfigEmail("noreploy@domain.com")

desc.save()
