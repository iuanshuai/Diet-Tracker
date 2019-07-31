# Diet-Tracker
[![Build Status](https://travis-ci.com/iuanshuai/Diet-Tracker.svg?branch=master)](https://travis-ci.com/iuanshuai/Diet-Tracker)
![Apache License, Version 2.0, January 2004](https://img.shields.io/github/license/iuanshuai/Diet-Tracker.svg?label=License)
![](https://img.shields.io/badge/Java-1.8-green.svg)

This application makes tracking calories and getting the proper nutrition easy. With the Diet-Tracker, you can get a personalized daily calorie goal, keep track of your weight and progress over time, and review detailed data and create custom goals for your micronutrients.

Project Technical Overview
-----------------------------------
* Java & IDE: JDK 8 IntelliJ
* Back-end:  Spring MVC 3.2.9 \(Configured by annotation)
* [Spring Security](https://spring.io/projects/spring-security)
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
    i. One user could have many records
    ii. One record could have several foods
    iii. One food could have many images
    iv. One record can only have one user
* Project Approach
    i. Created User, Food, Image, Record domain
    ii. Used Hibernate to do the database schema migration
    iii. Used JDBC to connect project with Postgres
    iv. Configured Spring Security for Authentication
    v. Created repository, service and did test
    vi. Did mock test for AWS S3 Storage service
    vii. Created Controllers and Restful APIs
    viii. Integrated third-party application AWS SQS and did Mock test
    ix. Used Postman to interact with back-end project
    x. Package my project into a Docker image

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
* Responsebody

2. User Login


3. Post Image to AWS S3


4. Send Message to AWS SQS




About
-----------------------------------

* [Github link](https://github.com/iuanshuai)
* [LinkedIn](https://www.linkedin.com/in/shuai-yuan-5a7baa159/)