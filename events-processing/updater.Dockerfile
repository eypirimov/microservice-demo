FROM events-processing_base:latest AS base

FROM openjdk:8-jre-slim

WORKDIR /updater

COPY --from=base /usr/src/app/updater/target/updater-*.jar /updater/updater.jar

CMD ["java","-jar","updater.jar"]