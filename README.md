# How to RUN the application
Build the project using **Gradle Clean Build** <br>
Now the run the application-it will be live on port 8080 of your localhost <br>
Now open POSTMAN with the localhost:8080 url followed by /employees <br>
According to various Requests select required Post,Get,Delete,Put options <br>
The embed database can also be accessed through /h2-console   (all the configurations are provided in application.properties) <br>

## You are good to go <br><br><br><br>




# Dependency Injection 
DevDB and ProdDB implements the DB interface which has public method getData which returns a string depending upon the class.<br>
AppConfig class(with @Configuration annotation) has 2 Beans defined for eaach of the DB-type classes.It also mentions the condition on the property defining when to instantiate which class.<br>
This dependency to be injected is mentioned in application.properties.<br>

# REST APIs
Several request methods are available(like GET,POST,DELETE,PUT)
This has been achieved through 3 layer structure(MVC) - <br>
Presentation Layer(used to interact with the client) <br>
Service Layer(contains the business logic) <br>
Persistence Layer(manages the database/repository) <br>


