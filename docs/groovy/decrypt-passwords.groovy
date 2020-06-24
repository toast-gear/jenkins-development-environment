#!/usr/bin/env groovy

/*

  Get the encrypted password from the credentials.xml file on the Jenkins master.
  Replace {XXX=} with the encrypted value (including the surrounding {})

*/

println(hudson.util.Secret.fromString("{XXX=}").getPlainText())
