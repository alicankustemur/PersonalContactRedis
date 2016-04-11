# Personal Contact

 This is a simple **Spring MVC** and **MongoDB** project.
 
 The goal of the project ; save person information to using basic database operations.
 
 ![PersonalContact Screenshoot](http://alicankustemur.github.io/images/PersonalContactScreenshoot-1.jpg)
 
 ![PersonalContact Screenshoot](http://alicankustemur.github.io/images/PersonalContactScreenshoot-2.jpg)
 
## Requirements

### Build
 - Maven
 - JDK 7 or later.
 
### Run

 These ones must be installed on your os for run.
 - Maven 
 - MongoDB 
 - Tomcat 7
 - JRE 7 or later.
 
## Installation

### Build
Run command-line in the project path and call it on command-line.
```sh
mvn package
```

Copy **personalcontact-1.0.0-BUILD-SNAPSHOT.war** file in **Project Path/target** folder to **Tomcat Path/wepapps** folder.

### Run

Run **MongoDB** and **Tomcat** and go to [http://localhost:8080/personalcontact-1.0.0-BUILD-SNAPSHOT/] (http://localhost:8080/personalcontact-1.0.0-BUILD-SNAPSHOT/) for deploying.**(if server port adress 8080 )**

Call these commands for running test classes.

```sh
mvn test
```
or one
```sh
mvn -Dtest=PersonControllerTest  test
mvn -Dtest=PersonServiceIntegrationTest  test
mvn -Dtest=PersonControllerWithServiceTest  test
```




