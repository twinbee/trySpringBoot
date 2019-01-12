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
java -jar target/trySpringBoot-0.0.1-SNAPSHOT.jar 
```

You should see something like this:
```
matthew@shiner MINGW64 /d/git/trySpringBoot (master)
$ java -jar target/trySpringBoot-0.0.1-SNAPSHOT.jar

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v1.5.3.RELEASE)

2019-01-12 12:21:02.685  INFO 2252 --- [           main] t.javaBrains.SpringBoot.RestApiAppDerby  : Starting RestApiAppDerby v0.0.1-SNAPSHOT on shiner with PID 2252 (D:\git\trySpringBoot\target\trySpringBoot-0.0.1-SNAPSHOT.jar started by matthew in D:\git\trySpringBoot)
2019-01-12 12:21:02.691  INFO 2252 --- [           main] t.javaBrains.SpringBoot.RestApiAppDerby  : No active profile set, falling back to default profiles: default
2019-01-12 12:21:02.815  INFO 2252 --- [           main] ationConfigEmbeddedWebApplicationContext : Refreshing org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@1de0aca6: startup date [Sat Jan 12 12:21:02 CST 2019]; root of context hierarchy
2019-01-12 12:21:05.875  INFO 2252 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat initialized with port(s): 8080 (http)
2019-01-12 12:21:05.897  INFO 2252 --- [           main] o.apache.catalina.core.StandardService   : Starting service Tomcat
2019-01-12 12:21:05.899  INFO 2252 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet Engine: Apache Tomcat/8.5.14
2019-01-12 12:21:06.738  INFO 2252 --- [ost-startStop-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2019-01-12 12:21:06.738  INFO 2252 --- [ost-startStop-1] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 3927 ms
2019-01-12 12:21:06.939  INFO 2252 --- [ost-startStop-1] o.s.b.w.servlet.ServletRegistrationBean  : Mapping servlet: 'dispatcherServlet' to [/]
2019-01-12 12:21:06.945  INFO 2252 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'characterEncodingFilter' to: [/*]
2019-01-12 12:21:06.946  INFO 2252 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'hiddenHttpMethodFilter' to: [/*]
2019-01-12 12:21:06.946  INFO 2252 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'httpPutFormContentFilter' to: [/*]
2019-01-12 12:21:06.946  INFO 2252 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'requestContextFilter' to: [/*]
2019-01-12 12:21:08.500  INFO 2252 --- [           main] j.LocalContainerEntityManagerFactoryBean : Building JPA container EntityManagerFactory for persistence unit 'default'
2019-01-12 12:21:08.538  INFO 2252 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [
        name: default
        ...]
2019-01-12 12:21:08.836  INFO 2252 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate Core {5.0.12.Final}
2019-01-12 12:21:08.839  INFO 2252 --- [           main] org.hibernate.cfg.Environment            : HHH000206: hibernate.properties not found
2019-01-12 12:21:08.842  INFO 2252 --- [           main] org.hibernate.cfg.Environment            : HHH000021: Bytecode provider name : javassist
2019-01-12 12:21:08.947  INFO 2252 --- [           main] o.hibernate.annotations.common.Version   : HCANN000001: Hibernate Commons Annotations {5.0.1.Final}
2019-01-12 12:21:09.359  INFO 2252 --- [           main] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.DerbyDialect
2019-01-12 12:21:09.378  WARN 2252 --- [           main] org.hibernate.dialect.DerbyDialect       : HHH000430: The DerbyDialect dialect has been deprecated; use one of the version-specific dialects instead
2019-01-12 12:21:10.742  INFO 2252 --- [           main] org.hibernate.tool.hbm2ddl.SchemaExport  : HHH000227: Running hbm2ddl schema export
2019-01-12 12:21:10.751 ERROR 2252 --- [           main] org.hibernate.tool.hbm2ddl.SchemaExport  : HHH000389: Unsuccessful: alter table course drop constraint FKokaxyfpv8p583w8yspapfb2ar
2019-01-12 12:21:10.751 ERROR 2252 --- [           main] org.hibernate.tool.hbm2ddl.SchemaExport  : Schema 'SA' does not exist
2019-01-12 12:21:10.752 ERROR 2252 --- [           main] org.hibernate.tool.hbm2ddl.SchemaExport  : HHH000389: Unsuccessful: drop table course
2019-01-12 12:21:10.752 ERROR 2252 --- [           main] org.hibernate.tool.hbm2ddl.SchemaExport  : Schema 'SA' does not exist
2019-01-12 12:21:10.753 ERROR 2252 --- [           main] org.hibernate.tool.hbm2ddl.SchemaExport  : HHH000389: Unsuccessful: drop table topic
2019-01-12 12:21:10.753 ERROR 2252 --- [           main] org.hibernate.tool.hbm2ddl.SchemaExport  : Schema 'SA' does not exist
2019-01-12 12:21:10.861  WARN 2252 --- [           main] o.h.engine.jdbc.spi.SqlExceptionHelper   : SQL Warning Code: 10000, SQLState: 01J01
2019-01-12 12:21:10.861  WARN 2252 --- [           main] o.h.engine.jdbc.spi.SqlExceptionHelper   : Database 'memory:testdb' not created, connection made to existing database instead.
2019-01-12 12:21:10.862  INFO 2252 --- [           main] org.hibernate.tool.hbm2ddl.SchemaExport  : HHH000230: Schema export complete
2019-01-12 12:21:10.943  INFO 2252 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2019-01-12 12:21:11.855  INFO 2252 --- [           main] s.w.s.m.m.a.RequestMappingHandlerAdapter : Looking for @ControllerAdvice: org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@1de0aca6: startup date [Sat Jan 12 12:21:02 CST 2019]; root of context hierarchy
2019-01-12 12:21:12.013  INFO 2252 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/topics/{topicId}/courses],methods=[GET]}" onto public java.util.List<twinbee.javaBrains.SpringBoot.database.courses.Course> twinbee.javaBrains.SpringBoot.database.courses.CourseController.getAllcourses(java.lang.String)
2019-01-12 12:21:12.016  INFO 2252 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/topics/{topicId}/courses/{courseId}],methods=[PUT]}" onto public void twinbee.javaBrains.SpringBoot.database.courses.CourseController.updateCourse(twinbee.javaBrains.SpringBoot.database.courses.Course,java.lang.String,java.lang.String)
2019-01-12 12:21:12.016  INFO 2252 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/topics/{topicId}/courses],methods=[POST]}" onto public void twinbee.javaBrains.SpringBoot.database.courses.CourseController.addCourse(twinbee.javaBrains.SpringBoot.database.courses.Course,java.lang.String)
2019-01-12 12:21:12.016  INFO 2252 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/topics/{topicId}/courses/{courseId}],methods=[GET]}" onto public twinbee.javaBrains.SpringBoot.database.courses.Course twinbee.javaBrains.SpringBoot.database.courses.CourseController.getCourse(java.lang.String)
2019-01-12 12:21:12.016  INFO 2252 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/topics/{topicId}/courses/{courseId}],methods=[DELETE]}" onto public void twinbee.javaBrains.SpringBoot.database.courses.CourseController.deletecourse(java.lang.String)
2019-01-12 12:21:12.018  INFO 2252 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/topics/{whichtopic}],methods=[GET]}" onto public twinbee.javaBrains.SpringBoot.database.topics.Topic twinbee.javaBrains.SpringBoot.database.topics.TopicController.gettopic(java.lang.String)
2019-01-12 12:21:12.019  INFO 2252 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/topics],methods=[GET]}" onto public java.util.List<twinbee.javaBrains.SpringBoot.database.topics.Topic> twinbee.javaBrains.SpringBoot.database.topics.TopicController.getAlltopics()
2019-01-12 12:21:12.019  INFO 2252 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/topics/{id}],methods=[DELETE]}" onto public void twinbee.javaBrains.SpringBoot.database.topics.TopicController.deletetopic(java.lang.String)
2019-01-12 12:21:12.019  INFO 2252 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/topics/{id}],methods=[PUT]}" onto public void twinbee.javaBrains.SpringBoot.database.topics.TopicController.updatetopic(twinbee.javaBrains.SpringBoot.database.topics.Topic,java.lang.String)
2019-01-12 12:21:12.020  INFO 2252 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/topics],methods=[POST]}" onto public void twinbee.javaBrains.SpringBoot.database.topics.TopicController.addtopic(twinbee.javaBrains.SpringBoot.database.topics.Topic)
2019-01-12 12:21:12.026  INFO 2252 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error]}" onto public org.springframework.http.ResponseEntity<java.util.Map<java.lang.String, java.lang.Object>> org.springframework.boot.autoconfigure.web.BasicErrorController.error(javax.servlet.http.HttpServletRequest)
2019-01-12 12:21:12.027  INFO 2252 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error],produces=[text/html]}" onto public org.springframework.web.servlet.ModelAndView org.springframework.boot.autoconfigure.web.BasicErrorController.errorHtml(javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse)
2019-01-12 12:21:12.088  INFO 2252 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/webjars/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
2019-01-12 12:21:12.088  INFO 2252 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
2019-01-12 12:21:12.159  INFO 2252 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**/favicon.ico] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
2019-01-12 12:21:12.567  INFO 2252 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
2019-01-12 12:21:12.698  INFO 2252 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8080 (http)
2019-01-12 12:21:12.705  INFO 2252 --- [           main] t.javaBrains.SpringBoot.RestApiAppDerby  : Started RestApiAppDerby in 10.623 seconds (JVM running for 11.26)

```
