#!/usr/bin/env groovy

/*
    Print the avaliable permissions and their class path.

    This is useful when scripting permissions in groovy, example output:

    Permission[class jenkins.metrics.api.Metrics,View]
    Permission[class jenkins.metrics.api.Metrics,ThreadDump]
    Permission[class jenkins.metrics.api.Metrics,HealthCheck]
    Permission[interface hudson.model.Item,Create]
    Permission[interface hudson.model.Item,Delete]
*/

import hudson.*
import hudson.security.*
import jenkins.model.*
import java.util.*
import com.michelin.cio.hudson.plugins.rolestrategy.*
import com.synopsys.arc.jenkins.plugins.rolestrategy.*
import java.lang.reflect.*
import java.util.logging.*
import groovy.json.*
import jenkins.*
import com.michelin.cio.hudson.plugins.rolestrategy.*

Logger logger = Logger.getLogger("")
  Permission.getAll().each { p ->
    logger.info(p.getId())
  }
