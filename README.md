# ClientManager-JDBC

A simple CRUD project built with **Spring Boot + JDBC** for managing customers.  
This project demonstrates how to work with **NamedParameterJdbcTemplate**, transactions, and plain SQL.

---

## 🚀 Features
- Create a customer (`POST /api/v1/create`)
- Update a customer (`POST /api/v1/update`)
- Delete a customer (`POST /api/v1/delete/{id}`)
- Find a customer by ID (`GET /api/v1/{id}`)

---

## 🛠 Tech Stack
- Java 17
- Spring Boot 3
- Spring JDBC (`NamedParameterJdbcTemplate`)
- MySQL
- Lombok

---

## ⚙️ Run locally

1. Clone the repository
   ```bash
   git clone https://github.com/Indeece/ClientManager-JDBC.git

2. Configure your MySQL database in application.yml
   ```bash
   spring:
    datasource:
      url: jdbc:mysql://localhost:3306/clientdb
      username: root
      password: your_password

3. Run the application
   ```bash
   ./mvnw spring-boot:run

