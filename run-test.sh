#!/bin/bash
set -e

#docker rm -f $(docker ps -aq)
#docker rmi $(docker images -f "dangling=false" -q)
#docker rmi $(docker images -f "dangling=true" -q)


docker-compose -f ./src/test/docker/docker-compose.yml kill || echo "no containers to kill "
docker-compose -f ./src/test/docker/docker-compose.yml rm -f || echo "no containers to remove"
docker-compose -f ./src/test/docker/docker-compose.yml build
docker-compose -f ./src/test/docker/docker-compose.yml up -d


chmod 775 ./src/test/docker/wait-container.sh

./src/test/docker/wait-container.sh sonar-db  "database system is ready to accept connections" 20
./src/test/docker/wait-container.sh ecommerce-db "database system is ready to accept connections" 20
./src/test/docker/wait-container.sh sonar-server "SonarQube is operational" 120


mvn clean install package sonar:sonar -Dsonar.login=admin -Dsonar.password=admin -Pcoverage
#mvn clean install package sonar:sonar -Dsonar.login=admin -Dsonar.password=admin -Pcoverage -Powasp-dependency-check
