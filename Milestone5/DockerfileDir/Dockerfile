FROM alpine
VOLUME /fsd
ADD carson-cloud-user-0.0.1-SNAPSHOT.jar user.jar
ENTRYPOINT ["java","-jar","/user.jar"]
EXPOSE 8080