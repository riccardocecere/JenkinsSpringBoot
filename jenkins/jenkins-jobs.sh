#!/bin/bash

curl --user 'admin:admin' --data-urlencode \
  "script=$(< ./job.groovy)" http://localhost:8090/scriptText

docker restart $(docker ps -f name=jenkins-server -q)
