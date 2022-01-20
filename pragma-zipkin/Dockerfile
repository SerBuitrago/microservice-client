FROM openjdk:11
VOLUME /tmp
EXPOSE 9411
ADD ./zipkin-server-2.23.16-exec.jar pragma-zipkin.jar
ENTRYPOINT [ "java", "-jar", "/pragma-zipkin.jar" ]