FROM openjdk
WORKDIR usr/src
EXPOSE 8085
#ENV MYSQL_USERNAME=user
#ENV MYSQL_PASSWORD=root
ADD ./target/UserAuthenticationService-0.0.1-SNAPSHOT.jar /usr/src/UserAuthenticationService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","UserAuthenticationService-0.0.1-SNAPSHOT.jar"]