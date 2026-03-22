# 🏥 Hospital Management System

A **Spring Boot based REST API project** for managing hospital operations like doctors, patients, appointments, and authentication.

---

## 🚀 Features

* 🔐 **Authentication & Authorization (JWT + OAuth2)**
* 👨‍⚕️ **Doctor Management**
* 🧑‍🤝‍🧑 **Patient Management**
* 📅 **Appointment Scheduling**
* 🏥 **Department Management**
* 🛡️ **Role-based Access Control**
* 📊 Clean layered architecture (Controller → Service → Repository)

---

## 🛠️ Tech Stack

* **Backend:** Java, Spring Boot
* **Security:** Spring Security, JWT, OAuth2
* **Database:** MySQL
* **ORM:** Spring Data JPA / Hibernate
* **Build Tool:** Maven
* **Testing:** JUnit

---

## 📂 Project Structure

```
src/
 ├── controller      # REST Controllers
 ├── service         # Business Logic
 ├── repository      # Database Layer
 ├── entity          # JPA Entities
 ├── dto             # Data Transfer Objects
 ├── security        # Auth & Security Config
 ├── config          # App Configurations
 └── resources       # application.properties / yml
```

---

## ⚙️ Setup & Run

### 1️⃣ Clone the repository

```bash
git clone https://github.com/OMAsati1/Hospital-Management-System.git
cd Hospital-Management-System
```

### 2️⃣ Configure Database

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/hospital_db
spring.datasource.username=your_username
spring.datasource.password=your_password
```

---

### 3️⃣ Run the project

Using Maven:

```bash
mvn spring-boot:run
```

OR

Run `HospitalManagementSystemApplication.java` directly from IDE

---

## 🔑 API Highlights

* `/auth/**` → Authentication APIs
* `/doctor/**` → Doctor operations
* `/patient/**` → Patient operations
* `/appointment/**` → Appointment handling

---

## 🧪 Testing

Run tests using:

```bash
mvn test
```

---

## 📌 Future Improvements

* 📊 Dashboard & Analytics
* 📱 Frontend integration (React/Angular)
* 🔔 Notifications (Email/SMS)
* 📦 Docker support

---

## 👨‍💻 Author

**Om Asati**
📌 GitHub: https://github.com/OMAsati1

---

## ⭐ Show your support

If you like this project, give it a ⭐ on GitHub!
