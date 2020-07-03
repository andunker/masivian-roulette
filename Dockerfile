# Build Stage
FROM maven:3.6.1-jdk-8 AS builder
WORKDIR /roulette
COPY pom.xml .
COPY ./src ./src
RUN mvn clean package

# Run Stage
FROM openjdk:8u201-jdk-alpine3.9
WORKDIR WORKSPACE /roulette
COPY --from=builder /roulette/target/roulette-0.0.1-SNAPSHOT.jar .
ENTRYPOINT java -Djava.net.preferIPv4Stack=true -jar roulette-0.0.1-SNAPSHOT.jar