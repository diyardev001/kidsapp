# Repository for the Software Engineering lecture

## Description of the Project

This project aims to create an application for children and young people in the city of Herne.
With the help of an interactive map, this application makes it possible for them to access offers in their area.
They will also be able to filter activities, save their preferences, rate the offers, and search for them.

## Team

Team Leader: Diyar Hasan

Members: Valentin Stein, Niklas Prinz, Abdul Balhas, Baturalp Kalabalik, Shengliang Wang


## Quickstart

This section outlines the steps required to get your project up and running quickly:

```bash,ignore
# Example: Start a PostgreSQL database using Docker
$ docker run --name some-postgres -e POSTGRES_PASSWORD=mysecretpassword -d postgres

# Example: Start the project (e.g., using Spring Boot)
$ ./mvnw spring-boot:ru
```

## Prerequisites

Detail all the necessary prerequisites for running your project, such as:

Operating System: (e.g., Linux, macOS, Windows)

Software: Docker, Java, Maven

Ports: (e.g., port 8080, if applicable)

## Installation and Setup

Provide step-by-step instructions on how to clone the repository, install the project, and configure it:

1. Clone the repository:
```bash,ignore
$ git clone https://github.com/devdiyar/kidsapp.git
```

2. Navigate to the project directory:
```bash,ignore
$ cd kidsapp
```

3. Adjust configuration files:

Modify configuration files (e.g., `.env`, `application.properties`) as required.


## Running the Project

Explain in detail how to run the project, including:

Starting the database

Initializing data (if needed, via scripts)

Starting the server

```bash,ignore
# Example: Initialize the database
$ ./init-db.sh

# Start the project
$ ./mvnw spring-boot:run
```

## Project structure
Provide an overview of the directory structure to help contributors navigate the project:
```bash,ignore
ProjectName/
├── project_one/        # Description of this subproject
├── docs/               # Documentation
├── tests/              # Test cases
└── README.md           # This file
```
