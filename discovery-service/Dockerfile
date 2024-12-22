FROM openjdk:17-oracle
VOLUME /tmp
COPY target/*.jar  discovery-service.jar
ENTRYPOINT ["java","-jar", "discovery-service.jar"]
#mvn clean package -DskipTest
