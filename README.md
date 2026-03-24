# 🏥 Hospital Management System

A Spring Boot backend for managing doctors, patients, and appointments.

## 🚀 Features
- Add and view doctors
- Add and view patients
- Create and manage appointments
- REST API based system
- PostgreSQL database integration

## 🛠️ Tech Stack
- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Lombok

## 📂 Project Structure
- Controller Layer
- Service Layer
- Repository Layer
- Entity Layer

## 🔗 API Endpoints

### Doctor
- POST /doctor
- GET /doctor

### Patient
- POST /patient
- GET /patient

### Appointment
- POST /appointment
- GET /appointment

## ⚙️ Setup Instructions

1. Clone the repository
2. Configure PostgreSQL in `application.properties`
3. Run the project:

```bash
./mvnw spring-boot:run
```

## 🧪 Sample Payloads

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

## 📌 Future Improvements
- Update & Delete APIs
- Authentication
- Frontend UI
- Swagger documentation
