

# 🛒 ShopKeeper Backend

This is the backend of the **ShopKeeper** full-stack inventory management application. Built using **Spring Boot**, it provides a RESTful API for managing products in an inventory system.

## 📦 Features

- RESTful CRUD endpoints for managing products
- Integrated with **MySQL**
- Swagger/OpenAPI documentation for testing
- Security ready (Spring Security dependency included)
- Uses environment variables or `.properties` for local configuration

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/shopkeeper.git
cd shopkeeper/backend
```

### 2. Set Environment Variables (Option A)

You can define the following in your shell profile (`~/.zshrc`, `~/.bashrc`, etc.):

```bash
export SPRING_DATASOURCE_USERNAME=your_mysql_username
export SPRING_DATASOURCE_PASSWORD=your_mysql_password
```

### 3. OR Create a Local Properties File (Option B)

Create `src/main/resources/application-local.properties`:

```properties
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
```

> ⚠️ Be sure to **exclude this file from Git**. It is already listed in `.gitignore`.

### 4. Run the Application

```bash
mvn spring-boot:run
```

## 🛠 API Documentation

Swagger UI will be available at:

```
http://localhost:8080/swagger-ui/index.html
```

Use it to test all endpoints including:
- `GET /api/products`
- `POST /api/products`
- `PUT /api/products/{id}`
- `DELETE /api/products/{id}`

## 🔐 Security (Coming Soon)

Spring Security is included but not yet configured. A JWT-based authentication system will be implemented.

---

## 📁 Project Structure

```bash
shopkeeper/backend/
├── src/main/java/dev/rono/shopkeeper/
│   ├── controller/         # REST API controllers
│   ├── model/              # JPA entities
│   ├── repository/         # Spring Data repositories
│   └── ShopKeeperApplication.java
├── src/main/resources/
│   └── application.properties
├── pom.xml
└── README.md
```

---

## 🧪 Future Plans

- ✅ Basic CRUD for Products
- 🔒 JWT Authentication
- 🧾 User Roles & Authorization
- 📊 Reporting / Metrics

---

## 🧑‍💻 Contributing

1. Fork the repository
2. Create your feature branch: `git checkout -b feature/my-feature`
3. Commit changes: `git commit -m 'Add my feature'`
4. Push to branch: `git push origin feature/my-feature`
5. Open a pull request

---

## 📄 License

MIT License © 2025 Rono
