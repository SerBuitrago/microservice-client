FROM openjdk:11
VOLUME /tmp
ADD ./target/pragma-image-mongodb-0.0.1-SNAPSHOT.jar pragma-image-mongodb.jar
ENTRYPOINT [ "java", "-jar", "/pragma-image-mongodb.jar" ]