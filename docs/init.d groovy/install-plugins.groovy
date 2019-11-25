#!/usr/bin/env groovy

/*
    Install plugins by referencing their ID your git config
    Script depends has no plugin dependencies
*/

import jenkins.*
import jenkins.model.*
import hudson.model.*

if(!Jenkins.instance.isQuietingDown()) {

  def instance = Jenkins.getInstance()
  def plugins = [ "git", "greenballs" ]
  println "" + plugins

  def pluginManager = instance.getPluginManager()
  def updateCentre = instance.getUpdateCenter()

  println "Ensure that plugins list is up to date "
  pluginManager.doCheckUpdatesServer()

  plugins.each {
    println "Checking " + it
    // Install plugin if it is not found in the plugin manager currently
    if (!pluginManager.getPlugin(it)) {
      def plugin = updateCentre.getPlugin(it)
      if (plugin) {
        println "Installing " + it
        def installFuture = plugin.deploy()
        while(!installFuture.isDone()) {
          println "Waiting for plugin install: " + it
          sleep(3000)
        }
      }
    }
  }

  def plugins_update = pluginManager.activePlugins.findAll {
    it -> it.hasUpdate()
  }.collect {
    it -> it.getShortName()
  }
  println "Plugins to upgrade: ${plugins_update}"
  long count = 0

  pluginManager.install(plugins_update, false).each { f ->
    f.get()
    println "${++count}/${plugins_update.size()}.."
  }

  println "Save Configuration"
  instance.save()

}
