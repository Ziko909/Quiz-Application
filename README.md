# Quiz-Application

Experience an immersive quiz application that seamlessly combines the robustness of Spring Boot for the backend with the dynamic user interface of React, offering a seamless and captivating quiz experience.

## Getting Started

Follow these instructions to get a copy of the project up and running on your local machine.

### Prerequisites

Make sure you have the following software installed on your machine:

- [Docker](https://docs.docker.com/get-docker/)
- [Docker Compose](https://docs.docker.com/compose/install/)
- [Java Development Kit (JDK)](https://adoptopenjdk.net/)
- [Maven](https://maven.apache.org/)

### Installation

1. **Install Docker and Docker Compose**

   Follow the official Docker documentation to install Docker and Docker Compose on your machine:

    - [Install Docker](https://docs.docker.com/get-docker/)
    - [Install Docker Compose](https://docs.docker.com/compose/install/)

2. **Install Java Development Kit (JDK)**

   Follow the official AdoptOpenJDK documentation to install the JDK on your machine:

    - [Install JDK](https://adoptopenjdk.net/)
3. **Install Maven**

   Follow the official Maven documentation to install Maven on your machine:

    - [Install Maven](https://maven.apache.org/install.html)

4. **Clone the repository**
   
    Open your terminal and run the following command to clone the repository:

```sh
   git clone https://github.com/Ziko909/Quiz-Application.git
   cd Quiz-Application
 ```

5. **Build the Spring Boot backend**

   Navigate to the backend directory and build the Spring Boot application using Maven:

```sh
 cd backend
 mvn clean install
 cd ..
   ```

This command will compile the project and package it into a JAR file.

### Define environment variables

Create a `.env` file in the root directory of the project and define these environment variables.

```env
POSTGRES_DB=question
POSTGRES_USER=user
POSTGRES_PASSWORD=123456789
DBHOST=postgres
POSTGRES_URL=jdbc:postgresql://postgres:5432/question
```
### Run Docker Compose

Now you can start the application using Docker Compose. Run the following command in your terminal:

```sh
    docker-compose up --build
```

This command will build the Docker images and start the containers for the application.