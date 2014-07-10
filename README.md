# Java Web Application

## Using technologies

* Spring Framework
* Spring MVC
* Spring Security
* MyBatis
* PostgreSQL

## How run project?

### Instruments

1. Clone this repository
2. Install PostgreSQL v9.3
3. Install Java v1.7
4. Install Tomcat v7.0.53 or later
4. Install Maven

### Config files

### PostgreSQL settings

Create user and database for our project.
 
Example:

  user: `java_web_app`
  
  database: `java_web_app_db`

### Tomcat settings

### Maven settings

### Deploy development version

1. Run `mvn package`
2. Run `mvn tomcat7:deploy` or `mvn tomcat7:redeploy`
