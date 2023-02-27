FROM openjdk:19
VOLUME /tmp
EXPOSE 8080
ADD ./target/minegocio-management-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
