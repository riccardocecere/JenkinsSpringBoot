#!/bin/bash

docker exec -u root $(docker ps -f name=jenkins-server -q) /bin/bash -c "apt-get update && apt-get install maven -y"
