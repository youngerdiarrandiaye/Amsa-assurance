FROM openjdk:17-oracle
VOLUME /tmp
COPY target/*.jar  souscription-service.jar
ENTRYPOINT ["java","-jar", "souscription-service.jar"]