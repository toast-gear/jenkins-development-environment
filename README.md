## jenkins-development-environment

### Rationale
Basically got tired of joining companies and testing Jenkins being hard. So I am now rolling my own environment from company to company

### Credentials
The docker-compose.yaml is set to run without credentials, this is set via teh `JAVA_OPTS` parameter `Djenkins.install.runSetupWizard=false`. If this is removed or set to `true` you will need to be aware of the below:

_By default the admin password is held in file on the master, on first run of the setup wizard the password should get printed into terminal. On subsequent runs you can find it again by cat'ing the contents of below file (assuming you haven't changed it)_<br /><br />
**Username :** admin<br />
**Password :** cat /var/jenkins_home/secrets/initialAdminPassword<br />

### Instructions
To build the images issue `docker-compose build`, to subsequently run the stack use `docker-compose up`

### Adding Jenkins Nodes
See each nodes README.md for details on how to add each type:<br />
* [Linux Node](./jenkins-node-linux/README.md)

### JAVA_OPTS Parameters
May want to use this for something, it is how you pass in parameters to the java environment<br />
https://wiki.jenkins.io/display/JENKINS/Features+controlled+by+system+properties