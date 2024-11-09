FROM openjdk
WORKDIR /app
COPY target/employee-crud-spring-boot.jar /app/
EXPOSE 8080
ENTRYPOINt ["java","-jar","employee-crud-spring-boot.jar"]
