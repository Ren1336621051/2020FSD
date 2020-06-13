FROM alpine
VOLUME /fsd
ADD carson-cloud-category-0.0.1-SNAPSHOT.jar category.jar
ENTRYPOINT ["java","-jar","/category.jar"]
EXPOSE 8080