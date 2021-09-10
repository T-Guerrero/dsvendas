FROM maven:3.8.2-jdk-11-slim AS MAVEN

WORKDIR /usr/src/app

COPY pom.xml .
COPY ./src ./src

RUN mvn clean package -DskipTests

FROM openjdk:11-jre-slim

COPY --from=MAVEN /usr/src/app/target/dsvendas-0.0.1-SNAPSHOT.jar dsvendas.jar

ENTRYPOINT ["java", "-jar", "dsvendas.jar"]