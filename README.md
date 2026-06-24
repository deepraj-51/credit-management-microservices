# Credit Management Microservices

A production-style microservices-based Credit Management System built using Spring Boot, Spring Cloud, PostgreSQL, Docker, and REST APIs.

The application helps businesses manage customers, track credit transactions, and securely authenticate users while demonstrating modern microservice architecture principles.

---

## Architecture Overview

The system follows a distributed microservices architecture where each service owns its own business logic and database.

### Services

| Service          | Responsibility                                   |
| ---------------- | ------------------------------------------------ |
| Auth Service     | User authentication and authorization            |
| Customer Service | Customer management operations                   |
| Credit Service   | Credit transaction and credit history management |
| Config Server    | Centralized configuration management             |
| Service Registry | Service discovery using Eureka                   |
| API Gateway      | Single entry point for all client requests       |

---

## Technology Stack

### Backend

* Java 17
* Spring Boot
* Spring Cloud
* Spring Security
* Spring Data JPA
* Hibernate

### Database

* PostgreSQL

### DevOps & Infrastructure

* Docker
* Docker Compose
* Eureka Service Discovery
* Spring Cloud Config Server
* API Gateway

### Build Tool

* Maven

---

## Microservice Architecture

```text
                ┌─────────────────┐
                │     Client      │
                └────────┬────────┘
                         │
                         ▼
                ┌─────────────────┐
                │   API Gateway   │
                └────────┬────────┘
                         │
      ┌──────────────────┼──────────────────┐
      ▼                  ▼                  ▼

┌─────────────┐   ┌─────────────┐   ┌─────────────┐
│ Auth Service│   │Customer Svc │   │Credit Svc   │
└──────┬──────┘   └──────┬──────┘   └──────┬──────┘
       │                 │                 │
       ▼                 ▼                 ▼

 PostgreSQL        PostgreSQL        PostgreSQL


      ┌────────────────────────────┐
      │       Config Server        │
      └────────────────────────────┘

      ┌────────────────────────────┐
      │      Eureka Registry       │
      └────────────────────────────┘
```

---

## Features

### Authentication

* User Registration
* User Login
* Secure Authentication
* Role-based access support

### Customer Management

* Create Customer
* Update Customer
* Delete Customer
* View Customer Details

### Credit Management

* Add Credit Transactions
* Track Outstanding Credit
* View Credit History
* Customer-wise Credit Records

### Microservice Features

* Service Discovery
* Centralized Configuration
* API Gateway Routing
* Independent Deployment
* Database Per Service Pattern

---

## Project Structure

```text
credit-management-microservices
│
├── api-gateway
├── service-registry
├── config-server
├── auth-service
├── customer-service
├── credit-service
│
├── config-repo
│
├── docker-compose.yml
│
└── README.md
```

---

## Getting Started

### Clone Repository

```bash
git clone https://github.com/your-username/credit-management-microservices.git
cd credit-management-microservices
```

---

### Build All Services

```bash
mvn clean install
```

---

### Run Using Docker Compose

```bash
docker-compose up --build
```

Run in detached mode:

```bash
docker-compose up -d
```

---

## Service Ports

| Service          | Port |
| ---------------- | ---- |
| API Gateway      | 8080 |
| Auth Service     | 8081 |
| Customer Service | 8082 |
| Credit Service   | 8083 |
| Eureka Server    | 8761 |
| Config Server    | 8888 |
| PostgreSQL       | 5432 |

---

## Configuration Management

All external configurations are managed through Spring Cloud Config Server.

Configuration files are stored in:

```text
config-repo/
```

Benefits:

* Centralized Configuration
* Environment Specific Properties
* Easier Maintenance
* Dynamic Configuration Updates

---

## Database Design

Each microservice maintains its own database.

```text
Auth Service
    └── auth_db

Customer Service
    └── customer_db

Credit Service
    └── credit_db
```

This follows the Database per Service pattern commonly used in microservice architectures.

---

## Future Improvements

* JWT Authentication
* Refresh Tokens
* OpenAPI / Swagger Documentation
* Distributed Tracing
* Circuit Breaker (Resilience4j)
* Centralized Logging
* Monitoring with Prometheus & Grafana
* Kubernetes Deployment
* CI/CD Pipeline using GitHub Actions
* Event-Driven Communication using Kafka

---

## Learning Outcomes

This project demonstrates:

* Microservices Architecture
* Service Discovery
* API Gateway Pattern
* Configuration Management
* Database per Service Pattern
* Docker Containerization
* Inter-Service Communication
* Spring Cloud Ecosystem
* Distributed System Fundamentals

---

## Author

**Deepraj Thakur**

GitHub: https://github.com/deepraj-51

---

## License

This project is created for learning and educational purposes.

