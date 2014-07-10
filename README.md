# Java Web Application

## Using technologies

* Spring Framework
* Spring MVC
* Spring Security
* JSP
* MyBatis
* PostgreSQL

## How run project?

### Instruments

Install next development tools:

1. PostgreSQL v9.3
2. Java v1.7
3. Tomcat v7.0.53 or later
4. Maven

### Config files

1. Create folder with name <config_path> for config files of project
2. Copy files from `./config_temaplates/*` folder in <config_path>

### Tomcat settings

1. Open or create file setenv.sh in $CATALINA_OPTS/bin
2. Add `JAVA_OPTS+='-Djava_web_app.config.path=<config_path>'` in setenv.sh

### PostgreSQL settings

Create user and database for our project.  
Example:  
- user: `java_web_app`  
- database: `java_web_app_db`

### Maven settings

1. Open or create ~/.m2/settings.xml
2. Add next xml:
```xml
<servers>
  <server>
    <id>tomcat7_manager</id>
    <username>tomcat_admin_username</username>
    <password>tomcat_admin_password</password>
  </server>
</servers>
```

### Deploy development version

1. Run `mvn package`
2. Run `mvn tomcat7:deploy` or `mvn tomcat7:redeploy`
