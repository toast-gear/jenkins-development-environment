## jenkins-node-linux

* [Root README](../README.md)

### Node Setup Parameters
You will need to add a new node and provide these details manually for the moment, this node is configured to use the below details:

**Remote root directory :** /home/jenkins<br />
**Launch method :** Launch agent agents via SSH<br />
**Host :** jenkins-node-linux _(This needs to match the service name in the docker-compose file)_<br />
**Credentials :** Add in the SSH private key from this repository in directly, no username required<br />
**Host Key Verification Strategy :** Non verifying Verification Strategy<br />
