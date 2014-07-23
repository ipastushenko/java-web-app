# Java Web Application

## Using technologies

* Spring Framework
* Spring MVC
* Spring Security
* JSP
* MyBatis
* PostgreSQL
* Flyway

## How run project?

### Instruments

Install next development tools:

1. PostgreSQL v9.3
2. Java v1.7
3. Tomcat v7.0.53 or later
4. Maven

### Config files

1. Create folder for config files of project. Example `mkdir ~/java-web-app/config/`. We define it as `<config_path>`
2. Copy files from `./config_temaplates/*` folder in `<config_path>`

### Tomcat settings

1. Open or create file `$CATALINA_HOME/bin/setenv.sh`
2. Add `JAVA_OPTS="$JAVA_OPTS -Djava_web_app.config.path=<config_path>"` in setenv.sh

### PostgreSQL settings

1. Create user and database for our project
2. Change `<config_path>/jdbs.properties` for user and database

### Maven settings

1. Open or create `~/.m2/settings.xml`
2. Add next xml:
```xml
<servers>
  <!-- flyway settings -->
  <server>
    <id>pg-java-web-app</id>
    <username>database_username</username>
    <password>database_password</password>
  </server>
  <!-- tomcat settings -->
  <server>
    <id>tomcat7_manager</id>
    <username>tomcat_admin_username</username>
    <password>tomcat_admin_password</password>
  </server>
</servers>
```

### Deploy development version

1. Run `mvn -Dflyway.url=<database-url> flyway:migrate`
2. Run `mvn package`
3. Run `mvn tomcat7:deploy` or `mvn tomcat7:redeploy`
