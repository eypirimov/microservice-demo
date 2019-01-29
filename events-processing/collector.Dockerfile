FROM events-processing_base:latest AS base

FROM openjdk:8-jre-slim

WORKDIR /collector

COPY --from=base /usr/src/app/collector/target/collector-*.jar /collector/collector.jar

CMD ["java","-jar","collector.jar"]