FROM jenkins/jenkins:lts

ENV JENKINS_HOME /var/jenkins_home

USER root
WORKDIR $JENKINS_HOME
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN /usr/local/bin/install-plugins.sh $(cat /usr/share/jenkins/ref/plugins.txt)
RUN mkdir $JENKINS_HOME/groovy.init.d
COPY groovy.init.d $JENKINS_HOME/groovy.init.d

USER jenkins

ENTRYPOINT ["/sbin/tini", "--", "/usr/local/bin/jenkins.sh"]