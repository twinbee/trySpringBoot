# trySpringBoot
Working through the JavaBrains.io SpringBoot course for developing a server-side REST API.

This is simply a place to keep my work for the javabrains tutorial on springBoot found here:
https://javabrains.io/courses/spring_bootquickstart/

Afterwards, I may use the repository to experiment with different other tutorials or features of SpringBoot / Spring MVC / Hibernate etc. 

## Overview

The javabrains tutorial develops a simple server-side REST API for a course management system (e.g. javabrans.io website, udemy, udacity, khan academy or similar). The application uses Spring, SpringBoot, and Java JPA for database / persistance. Out of the box it uses the embedded Apache Derby relational database. It is easy to switch to an installed persistent relational DB such as PostGres by changing the pom.xml dependencies.

This is not production code. There is no input sanitization, authentication, security, or data hiding. (Also, I do not entirely know what I am doing). Therefore you should not re-use this code. You have been warned. 

## Prerequisites

JDK version 1.8  (Java 8)or greater is required due to the use of lambda expressions. I am using JDK 11.

mvn must be installed to build. I am using apache-maven-3.6.0.

Other dependencies can be found in the pom.xml file, and will be fetched automatically from maven central or your configured maven repository. I have used eclipse JEE 2018-12 to develop, but any IDE that is integrated with maven should work well.


## REST endpoints / Usage

Rest APIs exposed allow the client to perform CRUD operations on courses and topics.

### /topics

#### GET
Retrieves the list of topics in JSON format

### /topics/{id}

#### GET
Retrieves the specific topic in JSON format

#### POST
Adds a new specific topic in JSON format. Payload header should be application/json.

#### PUT
Updates the specific topic in JSON format. Payload header should be application/json.

#### DELETE
Deletes the specific topic in JSON format. Payload header should be application/json.

### /topics/{topicId}/courses

#### GET
Retrieves all courses under the specific topic in JSON format.

### /topics/{topicId}/courses/{courseid}

#### GET
Retrieves the specific course in JSON format

#### POST
Adds a new specific course in JSON format. Payload header should be application/json.

#### PUT
Updates the specific course in JSON format. Payload header should be application/json.

#### DELETE
Deletes the specific course in JSON format. Payload header should be application/json.


## Build and deploy

In order to build the project into jar, simply type 
```
mvn install
```

In order to run:

```
java -jar  
```
