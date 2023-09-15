# Backend app

## Prerequisites

- maven 3.5+
- openjdk 17.0.8

## Docker

### Generate an image

Generate a docker image at the last version.

`docker build -t assignment-backend:latest .`

### Run it

`docker run -p 8080:8080 assignment-backend:latest`

## Install

`sudo apt install openjdk-17-jre-headless maven -y`

`./mvnw clean install`

## Run

`./mvnw spring-boot:run`

## Start mongodb

`sudo systemctl start mongod`

