FROM openjdk:17-oracle

WORKDIR /app

COPY target/*.jar democache.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "democache.jar"]