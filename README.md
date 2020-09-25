# GCP-Web-App

 Sample project to run on gcp


## Features
* GCP base setup
    * Logging & Tracing
* Swagger UI
* Open API 3.0.1
* Undertow


## Pre-req:
Spring Boot 2.3.1
Java 11+
GCP Console API

## SetUp

To start in dev mode.

```cmd
    cd service
    mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

```
 java -jar -Dspring.profiles.active=dev ./service/target/service-1.0-SNAPSHOT.jar
```


## Swagger UI:

http://localhost:8080/gcp-web-app/swagger-ui/index.html?configUrl=/gcp-web-app/api-docs/swagger-config