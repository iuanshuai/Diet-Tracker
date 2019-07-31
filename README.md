# Diet-Tracker
[![Build Status](https://travis-ci.com/iuanshuai/Diet-Tracker.svg?branch=master)](https://travis-ci.com/iuanshuai/Diet-Tracker)
![Apache License, Version 2.0, January 2004](https://img.shields.io/github/license/iuanshuai/Diet-Tracker.svg?label=License)
![](https://img.shields.io/badge/Java-1.8-green.svg)

This application makes tracking calories and getting the proper nutrition easy. With the Diet-Tracker, you can get a personalized daily calorie goal, keep track of your weight and progress over time, and review detailed data and create custom goals for your micronutrients.

Project Technical Overview
-----------------------------------
* [Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Spring Security](https://spring.io/projects/spring-security)
* [Hibernate](http://hibernate.org)
* [Postgres](https://www.postgresql.org)
* [Flyway](https://flywaydb.org/)
* [Tomcat](https://tomcat.apache.org/download-70.cgi)
* [Maven](https://maven.apache.org)
* [JUnit](http://junit.org/)
* [Docker](https://www.docker.com/)
* [Amazon SQS](https://aws.amazon.com/sqs/)
* [Amazon S3](https://aws.amazon.com/s3/)

Project Business Rules
-----------------------------------
* Object: User, Food, Image, Record
* Relationships:
    1. One user could have many records
    1. One record could have several foods
    1. One food could have many images
    1. One record can only have one user
* Project Approach
    1. Created User, Food, Image, Record domain
    1. Used Hibernate to do the database schema migration
    1. Used JDBC to connect project with Postgres
    1. Configured Spring Security for Authentication
    1. Created repository, service and did test
    1. Did mock test for AWS S3 Storage service
    1. Created Controllers and Restful APIs
    1. Integrated third-party application AWS SQS and did Mock test
    1. Used Postman to interact with back-end project
    1. Package my project into a Docker image

Build & Installation
-----------------------------------
* Install and run [PostgreSQL](hhttps://www.postgresql.org).
    ```
    docker pull postgres
    docker run --name dealerDB -e POSTGRES_DB=diettracker_unit -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=password -p 5430:5432 -d postgres
    ``` 
* Clone the repository and switch to the directory.
    ```
    clone https://github.com/iuanshuai/Diet-Tracker.git
    cd Diet-Tracker
    ```
* Environment configuration
    ```
    location:./src/main/resources/META-INF/env
       
    Template:
    database.driverName=${driverName}
    database.url=${url}
    database.port=${port}
    database.name=${name}
    database.username=${username}
    database.password=${password}
       
    mvn compile -Dspring.profiles.active=${env}
    ```
* Do the database migration
    ```
    mvn clean compile flyway:migrate -P unit -Ddb_username=admin -Ddb_password=password
    ```
* Create war package file `mvn clean compile package -DskipTests=true`.
* Deploy the `war` file in `target` to a application server of your choice (e.g. [Apache Tomcat](http://tomcat.apache.org/)). For example, if using tomcat, run `sh startup.sh`

Demo
-----------------------------------
1. User Sign Up
```
POST - http://localhost:8080/api/users/signup
```
* Requestbody
```
{
    "username": "trackertest",
    "password": "testpwd",
    "firstName": "Johnny",
    "lastName": "Appleseed",
    "email": "jappleseed@icloud.com" 
}
```
* Responsebody
```
{
    "username": "trackertest",
    "password": "$2a$10$DeoWMcongUSPkU.//RIOpOcpnBStF.cYGrcjiwwpSH3O9HBzh0k3y",
    "email": "jappleseed@icloud.com",
    "lastName": "Appleseed",
    "firstName": "Johnny",
    "id": 28,
    "accountNonExpired": true,
    "accountNonLocked": true,
    "credentialsNonExpired": true
}
```
* Postman snapshoot for user sign up
![](https://github.com/iuanshuai/Diet-Tracker/blob/master/pic/user%20sign%20up.png?raw=true)


2. User Login
```
POST http://localhost:8080/api/users/login
```
* Requestbody
```
{
    "username": "trackertest",
    "password": "testpwd"
}
```
* Responsebody
```
{
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0cmFja2VydGVzdCIsImNyZWF0ZWQiOjE1NjQ1OTk0MjM2OTAsImV4cCI6MTU2NDY4NTgyM30.9RfDGCSkp1Dxc_ZLeqLjcDfyRHbGJjDNDiCaZPwd8lyy5aqEEYyFzemOy9vGI_d7wdj9eAcalrI74teOUi56Hw"
}
```
* Postman snapshoot for user login 
![](https://github.com/iuanshuai/Diet-Tracker/blob/master/pic/user%20login.png?raw=true)

3. Post Image to AWS S3
* Postman snapshoot for post image to AWS S3
![](https://github.com/iuanshuai/Diet-Tracker/blob/master/pic/upload%20img.png?raw=true)



About
-----------------------------------

* [Github link](https://github.com/iuanshuai)
* [LinkedIn](https://www.linkedin.com/in/shuai-yuan-5a7baa159/)