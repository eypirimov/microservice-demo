#!/bin/sh

set -e

docker-compose down

echo "*** Building images for services"
docker-compose build


echo "*** Starting Apps "
docker-compose up

