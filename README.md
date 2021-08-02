# Spring Boot Hibernate Hazelcast Cache Example
  
<img src="https://github.com/susimsek/spring-boot-hibernate-hazelcast-cache-example/blob/main/images/spring-boot-hibernate-hazelcast-cache-example.png" alt="Spring Boot Hibernate Hazelcast Cache Example" width="100%" height="100%"/> 

## Prerequisites

* Docker 19.03+
* Docker Compose 1.25+

## Build Docker Image

```sh
./mvnw -Pprod compile jib:dockerBuild
```

## Installation

```sh
docker-compose up -d 
```

## Used Technologies

* Spring Boot
* Postgresql
* Hazelcast

### Shared Libraries

* Java 11 
* Spring Boot 2.5.3
* Spring Boot Starter Log4j2
* Spring Boot Starter Web
* Spring Boot Starter Actuator
* Spring Boot Starter Jpa
* Spring Boot Starter Cache
* Spring Boot Starter Test
* Cache Api
* Hazelcast
* Hazelcast Hibernate53
* Lombok
* Mapstruct
* Mapstruct Processor
* SpringDoc Openapi Ui
* SpringDoc Openapi Data Rest

### Dev Environment Libraries

* Spring Boot Starter Tomcat
* H2
* Dev Tools

### Prod Environment Libraries

* Spring Boot Starter Undertow
* Postgresql

### Plugins

* Spring Boot Maven Plugin
* Maven Compiler Plugin
* Maven Clean Plugin
* Jib Maven Plugin

### Features

* Swagger
* Audit
* Pagination
* Caching

## Swagger Support

You can access the SpringDoc ui from the following url.  

http://localhost:9090/swagger-ui.html

<img src="https://github.com/susimsek/spring-boot-hibernate-hazelcast-cache-example/blob/main/images/springdoc-ui.png" alt="SpringDoc Ui" width="100%" height="100%"/> 