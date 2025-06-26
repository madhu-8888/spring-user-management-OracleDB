# Spring User Management - OracleDB Version

This is a basic Spring MVC project using XML configuration and OracleDB, created using Spring Tool Suite (STS).

## Features
- Spring MVC with XML config
- OracleDB integration using JDBC
- CRUD operations: Create, Read, Update, Delete users
- RESTful endpoints

## How to Run
1. Clone the repo  
   `git clone https://github.com/madhu-8888/spring-user-management-OracleDB.git`

2. Import into Eclipse or STS

3. Create a `userdb` schema in Oracle DB

4. Update your DB credentials in the config XML or DAO

5. Deploy to Tomcat and test using Postman

## REST Endpoints

- `GET /users/getAllUsers`
- `POST /users/createUser`
- `PUT /users/{id}`
- `DELETE /users/{id}`

---

MIT License | Happy Coding!
