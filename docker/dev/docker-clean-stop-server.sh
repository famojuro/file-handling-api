#!/bin/bash

#$1 is for container name eg kkcms
#$2 is for image name eg intellectualapps/kkcms

docker stop $1
docker rm $1
docker image rm $2
