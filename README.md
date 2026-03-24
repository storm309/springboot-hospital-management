# Spring Boot Hospital Management

Basic Hospital Management System built with Spring Boot, Spring Web, Spring Data JPA, PostgreSQL, and Lombok.

## Features
- Manage doctors, patients, and appointments
- REST API endpoints for CRUD basics
- PostgreSQL persistence

## Tech Stack
- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- Lombok

## Configuration
Edit the database config in:
- src/main/resources/application.properties

Default settings:
- URL: jdbc:postgresql://localhost:5432/hospital_db
- Username: postgres
- Password: root

## Run
```bash
./mvnw spring-boot:run
```

## API Endpoints
- POST /doctor
- GET /doctor
- POST /patient
- GET /patient
- POST /appointment
- GET /appointment

### Example payloads
Create doctor:
```json
{ "name": "Dr. John", "specialization": "Cardiology" }
```

Create patient:
```json
{ "name": "Alice", "disease": "Flu" }
```

Create appointment:
```json
{ "doctor": { "id": 1 }, "patient": { "id": 2 }, "date": "2026-03-24" }
```
