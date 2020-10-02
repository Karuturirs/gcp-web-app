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

## Starting app

Using maven  and docker

```cmd
cd service
mvn spring-boot:build-image
docker run -d -p 8080:8080  -e JAVA_TOOL_OPTIONS="-Dspring.profiles.active=dev" gcp-web-app:1.0-SNAPSHOT
```

```cmd
#check the layers
java -Djarmode=layertools -jar target/service-1.0-SNAPSHOT.jar 

java -Djarmode=layertools -jar target/service-1.0-SNAPSHOT.jar list

java -Djarmode=layertools -jar target/service-1.0-SNAPSHOT.jar extract --destination target/tmp/
```

Build and start

```cmd
cd service
mvn clean install
docker run  -p 8080:8080  -e JAVA_TOOL_OPTIONS="-Dspring.profiles.active=dev" ${project.artifactId}:${project.version}
```

Using dockerfile

```cmd
cd service
mvn clean install
docker build --tag=gcp-web-app .
docker run  -p 8080:8080  -e JAVA_TOOL_OPTIONS="-Dspring.profiles.active=dev" gcp-web-app
```



To start in dev mode.

```cmd
    cd service
    mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

```
 java -jar -Dspring.profiles.active=dev ./service/target/service-1.0-SNAPSHOT.jar
 java -jar -XX:ActiveProcessorCount=3 -XX:MaxRAM=1500M -XX:InitialRAMPercentage=75.0  -XX:MaxRAMPercentage=75.0 -XX:MinRAMPercentage=75.0 -XX:+UseG1GC -XX:MetaspaceSize=256M -XX:MaxMetaspaceSize=512M -XX:+UseCompressedOops -XX:+UnlockExperimentalVMOptions -XX:+UnlockDiagnosticVMOptions -XX:+DebugNonSafepoints -XX:+DisableExplicitGC -Dspring.profiles.active=dev ./service/target/service-1.0-SNAPSHOT.jar
```


## Swagger UI:

http://localhost:8080/gcp-web-app/swagger-ui/index.html?configUrl=/gcp-web-app/api-docs/swagger-config
