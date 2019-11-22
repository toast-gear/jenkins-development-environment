FROM jenkins/jenkins:lts

USER root
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN /usr/local/bin/install-plugins.sh $(cat /usr/share/jenkins/ref/plugins.txt)

USER jenkins

ENTRYPOINT ["/sbin/tini", "--", "/usr/local/bin/jenkins.sh"]