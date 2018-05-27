FROM openjdk:8

ADD target/docker-spring-mysql.jar docker-spring-mysql.jar

EXPOSE 5556

ENTRYPOINT ["java", "-jar", "docker-spring-mysql.jar"]