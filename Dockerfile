#FROM centos
#
#RUN yum install -y java
#RUN rpm -e java-1.8.0-openjdk-1.8.0.191.b12-1.el7_6.x86_64
#
#VOLUME /tmp
#ADD /target/sklep-0.0.1-SNAPSHOT.jar posklep.jar
#RUN sh -c 'touch /posklep.jar'
#ENTRYPOINT ["java", "-Djava.security.edg=file:/dev/./urandom", "-jar", "/posklep.jar"]


FROM openjdk:8
VOLUME /tmp
ADD /target/sklep-0.0.1-SNAPSHOT.jar posklep.jar
#RUN sh -c 'touch /posklep.jar'
ENTRYPOINT ["java", "-Djava.security.edg=file:/dev/./urandom", "-jar", "/posklep.jar"]





#FROM openjdk:8-jdk-alpine
#
#LABEL maintainer="konradbosak@protonmail.com"
#
#VOLUME /tmp
#
#EXPOSE 8080
#
#ADD /target/POSklepAng.jar app-demo.jar
#
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom -ldl","-jar","/app-demo.jar"]

#FROM alpine:edge
#
#VOLUME /tmp
#ADD /target/POSklepAng.jar myapp.jar
#RUN sh -c 'touch /myapp.jar'
#ENTRYPOINT ["java", "-Djava.security.edg=file:/dev/./urandom", "-jar", "/myapp.jar -ldl"]
#
#
#
#



#FROM openjdk:8-jdk-alpine
#VOLUME /tmp
#ARG DEPENDENCY=target/dependency
#COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
#COPY ${DEPENDENCY}/META-INF /app/META-INF
#COPY ${DEPENDENCY}/BOOT-INF/classes /app
#ENTRYPOINT ["java","-cp","app:app/lib/*","hello.Application"]

#
#
#FROM ubuntu
#
#RUN apt-get install openjdk-8-jre
#
#VOLUME /tmp
#ADD /target/POSklepAng.jar myapp.jar
#RUN sh -c 'touch /myapp.jar'
#ENTRYPOINT ["java", "-Djava.security.edg=file:/dev/./urandom", "-jar", "/myapp.jar"]