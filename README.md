# NVS Calendar Project

This is a Web Application which serves as a calendar.

## Usage
This app serves as a backend for a calendar app. \
It provides a rest-api to add events and add/retrieve both events and national holidays 

## Deployment
The application gets deployed via docker. \
It consists of 2 parts: 
- MySql Database
- Java Backend

### Requirements
To deploy the application you will need:
- Docker (Docker Desktop if you work on Windows or Mac)
- Java 11 or higher
- Maven 3 or higher

### Database Setup
The database gets gets put in a Docker container. \
Since there are quite a lot of names involved I will be providing a description of each command followed by an example with all names already filled in

The data should not be lost when the container restarts, so you first need to create a volume \
`docker volume create <name-of-volume>` \
Example: `docker volume create data_nvs_project`

Since we are going to have multiple containers, we also need to create a network to ensure that the communication works \
`docker network create <name-of-network>` \
Example: `docker network create nvs_project`

Now, you can start the mysql container, which will be used as database \
For that we will be using the official mysql image from Docker Hub
`docker run --name <container-name> 
--restart-on-failure -v <volume-name(from above)> 
--network <network-name(from above)> 
-e MYSQL_ROOT_PASSWORD=<password> 
-e MYSQL_DATABASE=<name-of-database> 
-e MYSQL_USER=<user>
-e MYSQL_PASSWORD=<password>
-p <port-on-machine>:3306
-d
mysql` \

Example:
`docker run --name database-nvs-project
--restart-on-failure -v data_nvs_project 
--network nvs_project
-e MYSQL_ROOT_PASSWORD=root
-e MYSQL_DATABASE=nvs_project
-e MYSQL_USER=root
-e MYSQL_PASSWORD=root
-p 3050:3306
-d
mysql`

The container should now run \
To verify type `docker container ls` and the mysql container should show up

### Backend Setup

The backend is written in Java 11 using the Spring Framework \
To run it we will be using a jar file which will be created using maven 

Note: The commands below have to be executed in the project directory,
otherwise important files won't be found and the deployment will fail

#### Creating a Jar File
First, you need to clone the repository to your preferred location \
Then navigate to the location in the terminal and run `mvn clean install` \
The jar file should now be created and is located in the target folder.

#### Docker Image
Since there is no official docker image for this repository, you will have to build one yourself \
This can be done by running `docker build . -t <name-of-image>` \
Example: `docker build . -t nvs-backend` \

#### Running the image
The last step is to run the image in a container. \
`docker run 
--name <container-name>
--network <network-name(from above)>
-p <port-on-machine>:8085 
-d 
nvs-backend` \
Example: 
`docker run 
--name nvs-backend 
--network nvs-project 
-p 8085:8085 
-d 
nvs-backend`

The container should now be running. \
To verify you can run `docker container ls` and view the containers or by accessing the rest api on localhost
