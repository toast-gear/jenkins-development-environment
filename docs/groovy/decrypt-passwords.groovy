#!/usr/bin/env groovy

/*

  Get the encrypted password from the credentials.xml file on the Jenkins master.
  Replace {XXX=} with the encrypted value (including the surrounding {}). Run in
  https://$JENKINS_URL/script

*/

println(hudson.util.Secret.fromString("{XXX=}").getPlainText())


/*

  Run the below in https://$JENKINS_URL/script

*/

def creds = com.cloudbees.plugins.credentials.CredentialsProvider.lookupCredentials(
com.cloudbees.plugins.credentials.common.StandardCredentials.class,
    Jenkins.instance,
    null,
    null
);for (int i; i < creds.size(); i++) {
  println "\n========== Credential ${i+1} Start =========="
  creds[i].properties.each { println it }
  println "========== Credential ${i+1} End   ==========\n"
}
