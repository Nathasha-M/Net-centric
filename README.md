# Net-Centric Assignment Project

This repository contains a Net-Centric application project implemented using Spring Boot for the backend, a simple frontend, and MySQL for the database. The project is containerized using Docker for seamless deployment and testing.

## Project Description

The project is designed to manage employee data, providing API endpoints for CRUD operations and a simple frontend for user interaction. The backend interacts with a MySQL database, and all components are orchestrated using Docker.

## Features
- Frontend: A web interface to manage employee data, built with static HTML, CSS, and JavaScript, served via an Nginx Docker container.
- Backend: A Spring Boot application providing RESTful APIs for employee operations, running in a Docker container.
- Database: A MySQL database running in a Docker container to persist employee data
- CI/CD Pipeline: Jenkins is used for building and testing the project, integrated with GitHub for version control

## Setup Instructions

### Prerequisites
- Docker and Docker Compose installed on your system.
- Git installed for version control.
- Postman (optional) for testing API endpoints.
- Browser for frontend testing.

### Clone the Repository
```bash
git clone https://github.com/Nathasha-M/Net-centric.git
cd Net-centric
```

### Build and Run the Application with Docker
#### To build and run the application:
```bash
docker-compose up --build -d
```
#### To stop the application:
```bash
docker-compose down
```
#### To check container logs:
```bash
docker logs <container_name>
```
#### To check running containers:
```bash
docker ps
```

### Access the Application
- **Frontend**: Navigate to `http://localhost:8085` in your web browser.
- **Backend API**: API endpoints are exposed at `http://localhost:8082`.

### Testing the API
Use Postman or a similar tool to test the API endpoints. Example endpoints:
- `GET /api/employees`: Retrieve all employees.
- `POST /api/employees`: Add a new employee.
- `PUT /api/employees/{id}`: Update an existing employee.
- `DELETE /api/employees/{id}`: Delete an employee.


## Jenkins Integration
The project includes Jenkins integration for continuous integration and deployment.

### Steps to Use Jenkins
1. Access Jenkins at `http://<your_jenkins_url>`.
2. Set up a pipeline job pointing to this repository.
3. Use the `Build Now` option to trigger a build.
4. Monitor the build status in Jenkins.

## Troubleshooting
- If the backend fails to start, ensure that the database container is healthy and accessible.
- If you encounter CORS issues, verify the backend CORS configuration in `NetCentricApplication.java`.
- Check container logs for errors using `docker logs <container_name>`.



