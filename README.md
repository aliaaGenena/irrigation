# irrigation
you can add any plot (name, area, cropType) as it has many sensors(name,startHour,endHour,isCompleted,waterQuantity)

# Getting Started

you will need to have Java 8, Maven installed on your machine.


# Build and Run the Application
To build and run the application, navigate to the project directory and execute the following command:
mvn update
mvn clean install
mvn spring-boot: run

# Technologies Used

Spring Boot
Spring Data JPA
h2 database
Maven
springdoc
Lombok
mapstruct

# API documentation

 Swagger Link 

http://localhost:8080/swagger-ui/index.html?validatorUrl=none&configUrl=/v3/api-docs/swagger-config

you can manage Plot by endpoints
/addPlot
/editPlot
/listAllPlot
/plot/name/{name}

you can add new sensor by endpoint /addSensor and Note this sensor can assign to any plot at and can change it by endpoint /addSensorToPlot


# DB
database Configured As H2 database and access with Link
http://localhost:8080/h2-console

Notes: 
1-connect with defined userName and password without change
2-DB tables is initialized please validate startHour and endHour for sensors with your LocalTime

# Scheduler
scheduler runs every 1 hour to check if any sensor need to start.
scheduler runs every day resets all sensors status to irrigate next day


