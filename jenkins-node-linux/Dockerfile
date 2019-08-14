FROM jenkins/ssh-slave

USER root
RUN apt-get update && \
    apt-get install -y \
    apt-transport-https \
    ca-certificates \
    lsb-release \
    # Required for add-apt-repository
    software-properties-common 

# Install Docker
RUN curl -fsSL https://download.docker.com/linux/ubuntu/gpg | apt-key add - && \
    add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/debian $(lsb_release -cs) stable" && \
    apt-get update && \
    apt-get install -y docker-ce-cli && \
    rm -r /var/lib/apt/lists/*

ENTRYPOINT ["setup-sshd"]
