# Java Consumer Client

## Requirements
- Java 8
- Maven 3.2.3+
- API Token
- API Url

## Execution

Compile and package a Spring-Boot executable jar file:

```
mvn clean install
```

Run the executable jar:

```
java -jar target/java-consumer-client-1.0-SNAPSHOT.jar --API_URL=<ws://beta.bluzone.io/portal/consumer/raw> --API_TOKEN=<your.api.token>
```

### Execution from within Spring-Boot using Maven Spring-Boot Plugin:

```
mvn spring-boot:run -DAPI_TOKEN=<your.api.token> -DAPI_URL=ws://beta.bluzone.io/portal/consumer/raw
```

Alterntaviely, edit the src/main/resources/application.yml and hard code the values.  Assuming hard coded values, simply run:

```
mvn spring-boot:run
```

### Debugging
- Edit pom.xml and uncomment the configuration block for the spring-boot-maven-plugin.  
- Execute using ```mvn spring-boot:run```
- Attach a standard debugger to the jdwp configuration in the pom.xml

