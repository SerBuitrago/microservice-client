FROM openjdk:11
VOLUME /tmp
EXPOSE 8084

ADD ./target/pragma-config-0.0.1-SNAPSHOT.jar pragma-config.jar
ENTRYPOINT [ "java", "-jar", "/pragma-config.jar" ]

LABEL serbuitrago="Sergiostivesbb@ufps.edu.co"