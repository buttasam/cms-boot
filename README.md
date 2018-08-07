# CMS Spring Boot [![Build Status](https://travis-ci.com/buttasam/cms-boot.svg?token=XnPX8at6Nczst9oxaW5N&branch=master)](https://travis-ci.com/buttasam/cms-boot)
CMS based on [Spring Boot](https://spring.io/projects/spring-boot). 

The aim is to create relative small, flexible and extendable content management system based pure on Spring Boot and SQL database.

It is an alternative to complex solutions such as Liferay, which are quite hart to understand.

## Architecture

It is classical MVC application, so everyone can understand it very easy and quicky.

It uses awesome [Spring JPA](https://spring.io/guides/gs/accessing-data-jpa/) to manipulate entities.

## Quickstart

1) Clone repository
2) Go to project folder `cd cms-boot`
3) Build project `./gradlew build`
4) Run project `java -jar build/libs/cms-boot-0.2-SNAPSHOT.jar --spring.profiles.active=dev`
5) Run it on `localhost:8080`


### Login
You can login as admin or developer on: `/login` 
- `admin@admin.com / admin`
- `developer@admin.com / admin`

### IDEA Config

We recommand you to use IntelliJ IDEA.

#### Profile

Dev profile can be actived. In that case application-dev.yml is used and datasource
is h2 db. To do in idea go to 
 
`Run/Debug Configuration > Active Profiles > Insert "dev"`  

#### Lombok

Lombok is present and should be used in every entity. To run it smoothly in IDEA install Lombok plugin and 
turn on annotation processors in settings.
``