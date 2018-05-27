FROM tomcat:8-jre8

ADD target/docker-spring-mysql.war /usr/local/tomcat/webapps/

RUN sh -c 'touch /usr/local/tomcat/webapps/docker-spring-mysql.war'

ENTRYPOINT ["sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar /usr/local/tomcat/webapps/docker-spring-mysql.war"]

EXPOSE 5556