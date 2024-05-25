FROM    openjdk:22-buster

MAINTAINER  Ziko909

LABEL   description="This image contains a Spring Boot API to serve Quiz questions"

WORKDIR /app

COPY    ./target/Quiz-App-0.0.1-SNAPSHOT.jar  app.jar

EXPOSE  8080

ENTRYPOINT ["java", "-jar", "app.jar"]