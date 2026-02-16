# 🎓 Student Management System (Spring Boot)

A full-stack **Student Management System** built using **Java, Spring Boot, JDBC, MySQL, and Thymeleaf**, enhanced with a **responsive, animated UI** following industry standards.

---

## 🚀 Features

- ✅ Add Full-Time Students
- ✅ Add Part-Time Students
- ✅ View All Students
- ✅ Search Student by ID
- ✅ Remove Student
- ✅ Sort Students by:
  - ID
  - Name
  - Joining Date
- ✅ Responsive Dashboard with Cards
- ✅ Animations & Icons for Better UX

---

## 🧑‍💻 Tech Stack

| Layer           | Technology                 |
| --------------- | -------------------------- |
| Backend         | Java 21, Spring Boot (MVC) |
| Frontend        | Thymeleaf, HTML5, CSS3     |
| Styling         | Bootstrap 5                |
| Icons           | Font Awesome               |
| Database        | MySQL                      |
| Data Access     | JDBC                       |
| Build Tool      | Maven                      |
| Version Control | Git & GitHub               |

---

## 🏗 Project Architecture

Controller → Service (DAO) → Database
Controller → Thymeleaf Templates → UI

- Follows **MVC Architecture**
- Clean separation of concerns
- Industry-standard project structure

---

## 📁 Project Structure

src/main/java/com/hcl/hcl_sms
├── controller
├── dao
├── model
└── util

src/main/resources
├── templates
└── static/css

---

## ⚙️ Database Configuration

Create a MySQL database:

```sql
CREATE DATABASE student_db;

CREATE TABLE students (
  id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(50),
  last_name VARCHAR(50),
  student_type VARCHAR(20),
  joining_date DATE,
  fees DOUBLE,
  hours INT
);

Update application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/student_db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD


▶️ How to Run the Application

./mvnw clean spring-boot:run

Open the Browser;

http://localhost:8080
```
