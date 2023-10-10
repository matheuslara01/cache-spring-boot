# Spring Cache Demo

This Spring Boot project serves as a practical demonstration of the caching functionality provided by the Spring Framework. The main objective is to illustrate how caching can be configured and used in a Spring application, in addition to demonstrating the use of Docker and PostgreSQL.

## Table of Contents

- [Requirements](#requirements)
- [Project Configuration](#project-configuration)
- [Functionalities](#functionalities)
- [Cache in Spring](#cache-in-spring)
- [Running the Project with Docker](#docker)
- [Endpoints](#endpoints)
- [Example of use](#example-of-use)
- [License](#license)

<a name="requirements"></a>
## Requirements

Before you begin, make sure you have the following requirements installed on your system:

 - Java Development Kit (JDK) 17 or higher
 - Maven (for building the project)
 - Docker and Docker Compose
 - PostgreSQL (via Docker Compose)

<a name="project-configuration"></a>
## Project Configuration

Clone this repository to your local environment:

```sh


 git clone https://github.com/matheuslara01/cache-springboot.git

```

 - Open the project in your IDE.

 - Make sure JDK 17 (or higher) is set as the project version.

<a name="functionalities"></a>
## Functionalities


This project demonstrates the following functionalities:

 - Spring Cache Configuration.
 - Use of caching annotations.
 - Caching service methods to improve performance.
 - Using Docker and Docker Compose to configure a PostgreSQL container.

<a name="cache-in-spring"></a>
## Cache in Spring

The Spring Framework supports caching through annotations such as ``@Cacheable``, ``@CacheEvict``, and ``@CachePut``. These annotations can be used to control the caching behavior of methods in your services. 
See the official [Spring documentation](https://spring.io/guides/gs/caching/) for more information about configuring and using the cache: Spring Framework Caching.

<a name="docker"></a>
## Running the Project with Docker

This project uses Docker and Docker Compose to configure a PostgreSQL container. To run the project with Docker, follow these steps:

 - Navigate to the project root directory.

 - Run the following Maven command to build the project:

```sh


 mvn clean install

```

Run the following Docker Compose command to start the containers:

```sh


 docker-compose up -d

```

<a name="endpoints"></a>
## Endpoints

The project has the following main endpoints:

 - /user/{id}: Returns information about a user based on their ID.
 - /user: Save user.
 - /user/{id}: delete user.
 - user/clearCache: Clears the user cache.
 - user/getCache: Returns information about user cache

<a name="example-of-use"></a>
## Example of use

You can use any HTTP client, such as cURL or Postman, to interact with your project endpoints. Here is an example of usage:

 - Get information about an employee by ID (replace {id} with the employee ID):

```sh


GET http://localhost:8080/user/{id}

```

 - Clear user cache:

```sh


POST http://localhost:8080/user/clearCache

```

---
<a name="license"></a>
## License

This project is licensed under the [MIT License](https://opensource.org/licenses/MIT).
