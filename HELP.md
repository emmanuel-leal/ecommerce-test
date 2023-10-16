# Read Me First
To run service we need the folowing:
* Java 11
* Maven 3.9.1
* docker 
* Docker compose

# Getting Started

### Reference Documentation

#### File run.sh
* this file allows run the dockerized application, this runs with postgres connection, application runs in port 8082

#### File run-test.sh
* this file run all tests and create reports with coverage, and search for vulnerabilities
* also run the sonar server, credential are the default (admin,admin) 

#### docker rm -f $(docker ps -aq) --> deletes all docker containers
#### docker rmi $(docker images -f "dangling=false" -q) && docker rmi $(docker images -f "dangling=true" -q)  ---> deletes all docker images
