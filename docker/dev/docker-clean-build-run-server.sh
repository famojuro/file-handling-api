#!/bin/bash

#$1 is for container name eg mercury-api
#$2 is for image name eg ia/mercury-api

cd ../../
gradle clean build
cp build/libs/file-handling-ms-0.0.1.war docker/dev/
cd docker/dev/
docker stop $1
docker rm $1
docker image rm $2
docker build -t $2 .
docker run -d --name $1 -p 8080:8080 -p 4848:4848 $2
docker logs -f $1