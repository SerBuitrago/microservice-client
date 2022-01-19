FROM openjdk:11
VOLUME /tmp
EXPOSE 8761
ADD ./target/pragma-eureka-0.0.1-SNAPSHOT.jar pragma-eureka.jar
ENTRYPOINT [ "java", "-jar", "/pragma-eureka.jar" ]