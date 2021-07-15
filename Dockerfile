FROM adoptopenjdk:11-jre-hotspot
ADD src/docker/demo-0.0.1-SNAPSHOT.jar application.jar
ENTRYPOINT ["java","-jar","application.jar"]
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=container", "-jar", "application.jar"]
CMD java -Dserver.port=$PORT -jar application.jar