FROM openjdk:17-alpine
WORKDIR /spring/simplemicroservice-users
ENV MYSQL_HOST=db_mysql
ENV MYSQL_USER=user
ENV MYSQL_PASSWORD=secret
ENV MYSQL_DB=credits
COPY . .
EXPOSE 8080
RUN sh -c "./gradlew build --no-build-cache && ./gradlew bootRun"
