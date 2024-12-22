FROM openjdk:17-oracle
VOLUME /tmp
COPY target/*.jar  remboursement-service.jar
ENTRYPOINT ["java","-jar", "remboursement-service.jar"]