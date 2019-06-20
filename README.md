# Diet-Tracker
[![Build Status](https://travis-ci.com/iuanshuai/Diet-Tracker.svg?branch=master)](https://travis-ci.com/iuanshuai/Diet-Tracker)
![Apache License, Version 2.0, January 2004](https://img.shields.io/github/license/iuanshuai/Diet-Tracker.svg?label=License)
![](https://img.shields.io/badge/Java-1.8-green.svg)



Frameworks and Tools
-----------------------------------
* Java & IDE: JDK 8 IntelliJ
* Back-end:  SpringMVC3.2.9 Spring3.2.9 \(Configured by annotation)
* [Spring Security](https://spring.io/projects/spring-security)
* [Postgres](https://www.postgresql.org)
* [Flyway](https://flywaydb.org/)
* [Tomcat](https://tomcat.apache.org/download-70.cgi)
* [Maven](https://maven.apache.org)
* [JUnit](http://junit.org/)

System Features
-----------------------------------
* Integration of Spring core, Spring MVC
* Management of users through CRUD interface

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
* Run `mvn clean install`.
* Do the database migration
    ```
    mvn clean compile flyway:migrate -P unit -Ddb_username=admin -Ddb_password=password
    ```
* Deploy the `war` file in `target` to a application server of your choice (e.g. [Apache Tomcat](http://tomcat.apache.org/)).

About
-----------------------------------

* [Github link](https://github.com/iuanshuai)
* [LinkedIn](https://www.linkedin.com/in/shuai-yuan-5a7baa159/)