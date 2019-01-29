FROM maven:3.5.3-jdk-8-slim

COPY . /usr/src/app

WORKDIR /usr/src/app

RUN mvn clean package