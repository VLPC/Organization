# About project

This is a service, provides common CRUD operations.
The main business purpose of service is to operating with employees of organizations.

## Running project

Organization is a Spring Boot application built using Gradle. You can build a jar file and run it from the command line:

./gradlew clean build

./gradlew bootRun

You can then access Organization here: http://localhost:8080/

## Swagger

Visit http://localhost:8080/swagger-ui.html in your browser.

## Database configuration

Organization uses an in-memory database (H2).
In according to current settings, you can connect to H2 console using http://localhost:8080/h2-console