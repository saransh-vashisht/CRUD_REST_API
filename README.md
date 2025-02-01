## **📌 Project Overview**
This project is a **Spring Boot-based CRUD REST API** for managing users, integrated with **MySQL** as the database. It provides endpoints to **Create, Read, Update, and Delete (CRUD)** user data, making it an essential component of any full-stack application.

## **📌Tech Stack**:  

- **Backend**: Spring Boot (Spring MVC, Spring Data JPA)  
- **Database**: MySQL  
- **Build Tool**: Maven  
- **API Testing**: Postman  
- **Java Version**: 17+  

---
## **📌 Features**
✅ **Create User** - Add a new user to the system.  
✅ **Get User by ID** - Retrieve user details using their ID.  
✅ **Get All Users** - Fetch a list of all users.  
✅ **Update User** - Modify existing user information.  
✅ **Delete User** - Remove a user from the database.  

---
## **📌 Installation & Setup**
### **Step 1: Clone the Repository**
```sh
git clone https://github.com/your-username/springboot-crud-mysql.git
cd springboot-crud-mysql
```

### **Step 2: Configure MySQL Database**
Ensure MySQL is running and create a database:
```sql
CREATE DATABASE user_management_db;
```

### **Step 3: Update `application.properties`**
Modify the database credentials in `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/user_management_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
```

### **Step 4: Build & Run the Application**
Use **Maven** to build and start the application:
```sh
mvn clean install
mvn spring-boot:run
```
The application will start on **`http://localhost:8080`**.

---## **📌 API Reference**

### **1️⃣ Get All Users**
```http
GET /api/users
```
🔹 Fetches a list of all users.

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `api_key` | `string` | **Required**. Your API key |

**Response (JSON)**:
```json
[
    {
        "id": 1,
        "firstName": "John",
        "lastName": "Doe",
        "email": "johndoe@example.com"
    },
    {
        "id": 2,
        "firstName": "Jane",
        "lastName": "Smith",
        "email": "janesmith@example.com"
    }
]
```

---

### **2️⃣ Get User by ID**
```http
GET /api/users/{id}
```
🔹 Fetches user details using their ID.

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. ID of user to fetch |

**Response (JSON)**:
```json
{
    "id": 1,
    "firstName": "John",
    "lastName": "Doe",
    "email": "johndoe@example.com"
}
```

---

### **3️⃣ Create a User**
```http
POST /api/users
```
🔹 Adds a new user to the database.

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `api_key` | `string` | **Required**. Your API key |

**Request Body (JSON)**:
```json
{
    "firstName": "John",
    "lastName": "Doe",
    "email": "johndoe@example.com"
}
```
**Response**: `201 Created`

---

### **4️⃣ Update a User**
```http
PUT /api/users/{id}
```
🔹 Updates an existing user by ID.

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. ID of user to update |

**Request Body (JSON)**:
```json
{
    "firstName": "Johnny",
    "lastName": "Doe",
    "email": "johnny.doe@example.com"
}
```
**Response Code**: `200 OK`

---

### **5️⃣ Delete a User**
```http
DELETE /api/users/{id}
```
🔹 Deletes a user by their ID.

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. ID of user to delete |

**Response Code**: `200 OK`  
**Response Body**:
```json
"User successfully deleted"
```
---



##  **📌 Tools & Technologies Used**
- **Spring Boot** - Microservices framework  
- **Spring MVC** - API development  
- **Spring Data JPA** - Database interaction  
- **MySQL** - Relational database  
- **Maven** - Build tool  
- **Postman** - API testing  

---
## **📌 Project Structure**
```
springboot-restful-webservices
│── src/main/java/com/project/springboot_restful_webservices
│   ├── controller
│   │   ├── UserController.java
│   ├── service
│   │   ├── UserService.java
│   │   ├── impl
│   │   │   ├── UserServiceImpl.java
│   ├── repository
│   │   ├── UserRepository.java
│   ├── entity
│   │   ├── User.java
│   ├── exception
│   │   ├── ResourceNotFoundException.java
│   ├── SpringbootCrudMysqlApplication.java
│
│── src/main/resources
│   ├── application.properties
│
│── pom.xml

```

---
## **📌 Troubleshooting**
**1. MySQL Connection Fails**  
- Ensure MySQL service is running.  
- Check database username & password in `application.properties`.  

**2. Port 8080 Already in Use**  
- Run: `lsof -i :8080` (Mac/Linux) or `netstat -ano | findstr :8080` (Windows).  
- Kill the process: `kill -9 <PID>` or change the port in `application.properties`:
  ```properties
  server.port=8081
  ```

**3. Hibernate Table Creation Issues**  
- Try setting `spring.jpa.hibernate.ddl-auto=update` or `create-drop` for fresh schema.  

---
## **📌 Author**
👨‍💻 **Saransh Vashisht**  
📧 **saranshs557@gmail.com**  
🔗 **LinkedIn:** [saransh-vashisht](https://www.linkedin.com/in/saransh-vashisht/)  
🔗 **X:** [SaranshVashisht](https://x.com/SaranshVashist)

---