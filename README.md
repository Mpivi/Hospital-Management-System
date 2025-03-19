# Hospital Management System
Hospital Management System
Overview
The Hospital Management System is a full-stack web application developed using Java (Spring Boot), React.js, and MySQL. This system enables hospitals to digitize patient records, appointments, lab test results, and diagnoses, improving efficiency and data accessibility.

Features:
✅ Patient Management – Store and manage patient records efficiently.
✅ Appointments – Schedule and track doctor appointments.
✅ Lab Test Results – Securely store and retrieve patient test results.
✅ Diagnoses Tracking – Maintain patient history and diagnoses.
✅ Secure Authentication – Implemented JWT authentication for secure access.
✅ Unique Patient ID System – Uses UUIDs to ensure data integrity and privacy.

Tech Stack
Backend: Java (Spring Boot), Spring Security (JWT), Hibernate, MySQL
Frontend: React.js, Axios, Bootstrap
Database: MySQL
Version Control: Git & GitHub

Setup & Installation

1. Clone the Repository
bash
git clone https://github.com/yourusername/Hospital-Management-System.git
cd Hospital-Management-System

2. Backend Setup (Spring Boot)
Navigate to the backend directory:
bash
cd backend
Update application.properties with your MySQL credentials.
Run the backend server:
bash
Copiar
Editar
mvn spring-boot:run

3. Frontend Setup (React.js)
Navigate to the frontend directory:
bash
Install dependencies:
bash
npm install
Start the frontend server:
bash
npm start

API Endpoints
Endpoint	Method	Description
/api/patients	GET	Get all patients
/api/patients/{id}	GET	Get patient by ID
/api/patients	POST	Add a new patient
/api/auth/login	POST	Authenticate user

License
This project is open-source and available under the MIT License.
