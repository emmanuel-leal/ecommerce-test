#!/bin/bash
set -e

#docker rm -f $(docker ps -aq)
#docker rmi $(docker images -f "dangling=false" -q)
#docker rmi $(docker images -f "dangling=true" -q)

mvn clean package -DskipTests=true
docker-compose -f ./docker-compose.yml kill || echo "no containers to kill "
docker-compose -f ./docker-compose.yml rm -f || echo "no containers to remove"
docker-compose -f ./docker-compose.yml build
docker-compose -f ./docker-compose.yml up -d
./src/test/docker/wait-container.sh ecommerce-db-postgress "database system is ready to accept connections" 20
./src/test/docker/wait-container.sh ecommerce-service "Started EcommerceTestApplication" 30