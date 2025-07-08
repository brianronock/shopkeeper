# 🛒 ShopKeeper Backend – `1-api-products` Branch

This branch contains the initial implementation of the **Product API** for the ShopKeeper application. It includes CRUD operations for managing products using Spring Boot and MySQL.

## 📦 Features Implemented

- ✅ Create, Read, Update, Delete endpoints for Product entity
- ✅ Integration with MySQL using Spring Data JPA
- ✅ Swagger UI enabled for interactive API testing
- ✅ Basic input validation with `@Valid`
- 🔐 Spring Security dependency added (not yet configured)

## 🚀 Getting Started

### 1. Clone & Checkout This Branch

```bash
git clone https://github.com/your-username/shopkeeper.git
cd shopkeeper
git checkout 1-api-products
cd backend
```

### 2. Setup Local Configuration

#### Option A: Use Environment Variables

Add these to your `~/.zshrc` or shell profile:

```bash
export SPRING_DATASOURCE_USERNAME=your_mysql_username
export SPRING_DATASOURCE_PASSWORD=your_mysql_password
```

#### Option B: Create a local `.properties` file

Create `src/main/resources/application-local.properties`:

```properties
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
```

> ⚠️ This file is already excluded from Git via `.gitignore`.

### 3. Run the Backend

```bash
mvn spring-boot:run
```

## 🛠 API Endpoints

Swagger UI (after running):  
`http://localhost:8080/swagger-ui/index.html`

Available endpoints:
- `GET /api/products`
- `GET /api/products/{id}`
- `POST /api/products`
- `PUT /api/products/{id}`
- `DELETE /api/products/{id}`

## 📁 Project Structure (Backend)

```bash
backend/
├── controller/         # ProductController.java
├── model/              # Product.java (JPA entity)
├── repository/         # ProductRepository.java
├── config/             # SecurityConfig.java (stub)
├── resources/
│   ├── application.properties
│   └── application-local.properties (ignored)
├── pom.xml
└── README.md
```

## 📄 License

MIT License © 2025 Rono
