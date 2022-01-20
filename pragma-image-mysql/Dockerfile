FROM openjdk:11
VOLUME /tmp
ADD ./target/pragma-image-mysql-0.0.1-SNAPSHOT.jar pragma-image-mysql.jar
ENTRYPOINT [ "java", "-jar", "/pragma-image-mysql.jar" ]