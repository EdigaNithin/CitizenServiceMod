FROM openjdk:17-alpine
ADD target/citizenservice.jar citizenservice.jar
ENTRYPOINT ["java" , "-jar", "citizenservice.jar"]
EXPOSE 8080