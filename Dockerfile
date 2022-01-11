FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8084
ADD build/libs/*.jar springbootpostgresqldocker-0.0.1-SNAPSHOT.jar 
#springbootpostgresqldocker.jar
ENTRYPOINT ["java","-jar","/springbootpostgresqldocker.jar"]
