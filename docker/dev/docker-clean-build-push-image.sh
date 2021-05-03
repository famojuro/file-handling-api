#!/bin/bash

#$1 is for container name eg mashacore
#$2 is for image name eg intellectualapps/mashacore

cp ../../../build/libs/masha-core-0.0.1.war .
docker stop $1
docker rm $1
docker image rm $2
docker build -t $2 .
docker push $2:latest