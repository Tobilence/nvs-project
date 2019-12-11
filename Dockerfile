FROM openjdk:11
ADD target/nvs-project.jar nvs-project.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "nvs-project.jar"]