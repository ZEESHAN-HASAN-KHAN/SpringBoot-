## Step 1: Base Image choose karo (Choose a base image)
## Hum ek lightweight OpenJDK image use kar rahe hain jo Java runtime environment provide karega.
#FROM eclipse-temurin:17-jdk-alpine
#
## Step 2: Working directory set karo container ke andar (Set the working directory inside the container)
## Is directory mein apki application files rahengi.
#WORKDIR /app
#
## Step 3: Apni JAR file ko container mein copy karo (Copy your JAR file into the container)
## 'target/*.jar' ka matlab hai ki target folder ke andar koi bhi .jar file ko copy karo.
## Usko container mein 'app.jar' naam do.
#COPY target/*.jar app.jar
#
## Step 4: Application ka port expose karo (Expose the application port)
## Ye Docker ko batata hai ki container kis port par listen karega.
## Spring Boot applications default roop se 8080 par chalti hain.
#EXPOSE 8081
#
## Step 5: Container start hone par kya command chalana hai (Command to run when the container starts)
## Ye command apki Spring Boot application ko run karega.
#ENTRYPOINT ["java", "-jar", "app.jar"]
#
## Step 6: docker build -t my-springboot-app .
## This will build Docker Image
#
##Step 7: docker run -p 8080:8080 my-springboot-app
##This will run a container of this image



# 🧱 Step 1: Build Stage
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# 🚀 Step 2: Run Stage
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]
