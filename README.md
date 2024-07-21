# Microservices and Microfrontends Project

## Overview

This project demonstrates a microservices architecture with microfrontends, using Docker and Docker Compose. It includes several services that work together to form a complete system, with a reverse proxy setup using Nginx, an API gateway for routing, and a service discovery mechanism using Eureka.

## Architecture

The architecture consists of the following components:

- **PostgreSQL Database**: Stores data for the microservices.
- **API Gateway**: Routes API requests to the appropriate services.
- **Eureka Server**: Provides service discovery to enable dynamic scaling and easy management of service instances.
- **User Service**: Handles user-related functionalities and interactions with the user data.
- **Product Service**: Handles product-related functionalities and interactions with the product data.
- **User Frontend**: A React application for user-related interactions.
- **Product Frontend**: A React application for product-related interactions.
- **Shell App Frontend**: The main React application that provides navigation to different microfrontends.
- **Nginx Reverse Proxy**: Routes requests to the appropriate frontend services.

## Services

### PostgreSQL

- **Purpose**: Provides a relational database for storing user and product data.
- **Configuration**: The database is initialized with scripts to set up the necessary tables and initial data.

### API Gateway

- **Purpose**: Acts as a single entry point for all API requests, forwarding them to the appropriate microservice.
- **Configuration**: Uses Spring Cloud Gateway for routing and load balancing.

### Eureka Server

- **Purpose**: Manages service discovery, allowing microservices to find and communicate with each other.
- **Configuration**: Registers all microservices, making them discoverable.

### User Service

- **Purpose**: Provides REST APIs for user-related operations.
- **Configuration**: Connects to the PostgreSQL database to manage user data.

### Product Service

- **Purpose**: Provides REST APIs for product-related operations.
- **Configuration**: Connects to the PostgreSQL database to manage product data.

### User Frontend

- **Purpose**: A React-based frontend for user-related functionalities.
- **Configuration**: Built using React and communicates with the User Service via the API Gateway.

### Product Frontend

- **Purpose**: A React-based frontend for product-related functionalities.
- **Configuration**: Built using React and communicates with the Product Service via the API Gateway.

### Shell App Frontend

- **Purpose**: The main React application that serves as the entry point, providing navigation links to the User and Product frontends.
- **Configuration**: Built using React Router to navigate between different frontends.

### Nginx Reverse Proxy

- **Purpose**: Routes HTTP requests to the appropriate frontend services.
- **Configuration**: Acts as a reverse proxy, directing traffic based on the URL path.

## Setup and Running

### Prerequisites

- Docker
- Docker Compose

### Running the Project

To start the project, navigate to the project directory and run:

```sh
docker-compose up --build
```

This command will build and start all the services defined in the docker-compose.yml file. The services will be accessible through the Nginx reverse proxy on port 80.

### Accessing the Services
- **User Frontend**: Accessible at http://localhost/users
- **Product Frontend**: Accessible at http://localhost/products
- **Shell App Frontend**: Accessible at http://localhost/
### Healthchecks
Each service includes a healthcheck configuration to ensure it is running correctly. Healthchecks are defined in the docker-compose.yml file and monitor the status of each service.

### Networks
- **spring-db**: Network for database communication.
- **spring-cloud**: Network for service communication.
- **spring-front**: Network for frontend communication.
### Volumes
- **pg_data**: Persistent storage for PostgreSQL data.
## Conclusion
This project sets up a robust microservices and microfrontends architecture using Docker and Docker Compose. The use of Nginx as a reverse proxy, an API gateway for routing, and Eureka for service discovery ensures a scalable and maintainable system.

## Licensing
This project is licensed under the MIT License. See the LICENSE file for more details.
