

# 🛍️ ShopKeeper

**ShopKeeper** is a full stack inventory management system designed for small to medium-sized businesses. It allows users to manage products efficiently via a modern Vue.js frontend and a Spring Boot + MySQL backend.

---

## 📂 Project Structure

```
shopkeeper/
│
├── backend/               # Spring Boot REST API (Java 17)
│   ├── src/main/java/
│   │   └── dev/rono/shopkeeper/
│   │       ├── config/            # Security configuration
│   │       ├── controller/        # Product REST controller
│   │       ├── model/             # JPA entity for Product
│   │       └── repository/        # Spring Data JPA repository
│   └── src/main/resources/
│       └── application.properties
│
├── frontend/              # Vue.js SPA (in progress)
│   ├── public/
│   └── src/
│       ├── assets/
│       ├── components/
│       ├── views/
│       └── App.vue
│
├── .gitignore
├── .gitattributes
└── README.md              # ← You're here
```

---

## 🚀 Getting Started

### 🔧 Backend Setup

1. Navigate to `backend/` and run:

```bash
mvn spring-boot:run
```

2. Backend runs on: `http://localhost:8080`

3. Swagger UI (if enabled): `http://localhost:8080/swagger-ui.html`

### 🔧 Frontend Setup (Vue)

1. Navigate to `frontend/`:

```bash
npm install
npm run dev
```

2. Frontend runs on: `http://localhost:5173`

---

## 🛡️ Security

- Spring Security is enabled.
- Default in-memory login (for development):

```properties
spring.security.user.name=admin
spring.security.user.password=admin
```

- JWT-based authentication planned for future release.

---

## 🗃️ Database

- MySQL with credentials stored in environment or `application.properties` (excluded via `.gitignore`)
- HikariCP for connection pooling
- Auto table creation via JPA

---

## ✅ Completed Features

- [x] Product model
- [x] CRUD REST API for Products
- [x] MySQL integration
- [x] Swagger documentation
- [x] Spring Security config
- [x] Environment-based config loading

---

## 📌 Roadmap

- [ ] Full frontend integration
- [ ] User registration & login (JWT)
- [ ] Role-based access
- [ ] Docker Compose setup
- [ ] Admin dashboard & metrics

---

## 📄 License

MIT License © 2025 Rono

---
