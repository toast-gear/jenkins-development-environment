#!/usr/bin/env groovy

/*
    Configure the security realm to be github with Photobox details
    Script depends on the following plugins:
    1. github-oauth

    https://github.com/sdelrio/jenkins/blob/master/github-oauth.groovy
*/

import hudson.security.SecurityRealm
import org.jenkinsci.plugins.GithubSecurityRealm

// TODO: These values should be provided as part of the group_vars and the secrets should be encrypted with vault
String githubWebUri = GithubSecurityRealm.DEFAULT_WEB_URI
String githubApiUri = GithubSecurityRealm.DEFAULT_API_URI
String clientID = ''
String clientSecret = ''
String oauthScopes = ''

if(!Jenkins.instance.isQuietingDown()) {
    SecurityRealm github_realm = new GithubSecurityRealm(githubWebUri, githubApiUri, clientID, clientSecret, oauthScopes)
    //check for equality, no need to modify the runtime if no settings changed
    if(!github_realm.equals(Jenkins.instance.getSecurityRealm())) {
        Jenkins.instance.setSecurityRealm(github_realm)
        Jenkins.instance.save()
        println 'Security realm configuration has changed.  Configured GitHub security realm.'
    } else {
        println 'Nothing changed.  GitHub security realm already configured.'
} else {
    println 'Shutdown mode enabled.  Configure GitHub security realm SKIPPED.'
}
