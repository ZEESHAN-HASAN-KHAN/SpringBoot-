FROM openjdk
WORKDIR usr/src
ENV MONGO_URI=mongodb://mongodbservice:27017/movie_db
ADD ./target/UserMovieService-0.0.1-SNAPSHOT.jar /usr/src/UserMovieService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","UserMovieService-0.0.1-SNAPSHOT.jar"]
