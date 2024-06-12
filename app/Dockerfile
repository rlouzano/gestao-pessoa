#CRIAR UM AMBIENTE COM JDK E O MAVEN
# COMPILAR A APLICAÇÃO
# EXECUTAR O COMANDO DO JAVA PARA EXECUTAR A APP

#Use a imagem oficial do Maven, que ja inclui o JDK
FROM maven:3.9.7-amazoncorretto-17-debian

#Copie seu codigo fonte para o conteiner
COPY . /usr/src/app

#Defina o diretorio de trabalho
WORKDIR /usr/src/app

#Construa o projeto com Maven
RUN mvn clean install

#Exponha a porta que sua aplicação usa
EXPOSE 8080

#Comando para iniciar sua aplicação
CMD ["java", "-jar", "target/pessoa-1.0.0.jar"]



#FROM maven:3.9.7 AS build
#RUN mkdir -p /home/src/app
#WORKDIR /home/src/app
#ADD . /home/src/app
#RUN mvn package
#
#FROM openjdk:17-alpine
#RUN mkdir -p /home/src/app
#WORKDIR /home/src/app
#COPY --from=build /home/src/app/target/pessoa-1.0.0.jar app.jar
#EXPOSE 8080
#CMD ["java", "-jar", "app.jar"]

#docker network create spring-network
#docker network connect spring-network louzano-mysql
# docker build -t app .
#docker run -p 8080:8080 --name spring-mysql --net spring-network -e MYSQL_HOST=louzano-mysql -e MYSQL_USER=root -e MYSQL_PASSWORD=56147865 -e MYSQL_PORT=3306 app