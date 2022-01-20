FROM openjdk:11
VOLUME /tmp
EXPOSE 8080
ADD ./target/pragma-gateway-0.0.1-SNAPSHOT.jar pragma-gateway.jar
ENTRYPOINT [ "java", "-jar", "/pragma-gateway.jar" ]