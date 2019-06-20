# Diet-Tracker
[![Apache License, Version 2.0, January 2004](https://img.shields.io/github/license/iuanshuai/Diet-Tracker.svg?label=License)][license]



Frameworks and Tools
-----------------------------------
* Java&IDE: JDK8 IntelliJ
* Backend:  SpringMVC3.2.9 Spring3.2.9 \(Configured by annotation)
* Database: Postgres
* Web Server: Tomcat 7
* Build Tool: Maven
* Other: Druid(database connection pool) JUnit Log4j Jackson FastJson

System Features
-----------------------------------
* Integration of Spring core, Spring MVC, and MyBatis
* Management of users through CRUD interface

Code Generator for MyBatis
-----------------------------------
* You can find code generator from [the link](http://mybatis.github.io/generator/)
* In the folder of mybatis-generator, you can find generator.xml and mybatis-generator-core-1.3.2.jar. 
* Download these two files in the folder of C:\mybatis, and run the following command:
  java -jar mybatis-generator-core-1.3.2.jar -configfile generator.xml -overwrite
* Then Java POJOs that match the table structure will be generated.

About
-----------------------------------

* [Github link](https://github.com/iuanshuai)
