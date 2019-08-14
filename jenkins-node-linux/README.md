## jenkins-node-linux

* [Root README](../README.md)

### Node Setup Parameters
You will need to add a new node and provide these details, this node uses SSH

**Remote root directory :** /home/jenkins<br />
**Host :** jenkins-node-linux _(This needs to match teh service name in the docker-compose file)_<br />
**Launch method :** Launch agent agents via SSH<br />
**Credentials :** Add in the SSH private key from this repository in directly<br />
**Host Key Verification Strategy :** Non verifying Verification Strategy<br />
