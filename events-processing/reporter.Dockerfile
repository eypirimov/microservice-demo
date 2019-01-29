FROM events-processing_base:latest AS base

FROM openjdk:8-jre-slim

WORKDIR /reporter

COPY --from=base /usr/src/app/reporter/target/reporter-*.jar /reporter/reporter.jar

CMD ["java","-jar","reporter.jar"]