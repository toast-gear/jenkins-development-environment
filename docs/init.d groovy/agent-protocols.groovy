#!/usr/bin/env groovy

/*
    Configure the enabled protocols for agent to master communication
    Script depends has no plugin dependencies
*/

import jenkins.model.Jenkins
import jenkins.security.s2m.*

def instance = Jenkins.getInstance()

// Enable Agent to master security subsystem
println "Enable Agent to master security subsystem"
instance.injector.getInstance(AdminWhitelistRule.class).setMasterKillSwitch(false);

// Disable jnlp
println "Disable JNLP"
instance.setSlaveAgentPort(-1);

// Disable old Non-Encrypted protocols
println "Disable non-encrypted protocols"
HashSet<String> newProtocols = new HashSet<>(instance.getAgentProtocols());
newProtocols.removeAll(Arrays.asList(
  "JNLP3-connect", "JNLP2-connect", "JNLP-connect", "CLI-connect"
));

instance.setAgentProtocols(newProtocols);
instance.save()
