# Training Institute Management System (TIMS)

A complete, full-stack educational administration dashboard crafted with Java Spring Boot, Hibernate, Thymeleaf, and a modernized dynamic interface.

## 🚀 Features

- **Full Data CRUD**: Securely create, read, update, and delete institutional records.
- **Relational Architecture**: Handles complex mapping between `Courses`, `Students`, `Trainers`, and `Fees`.
- **Environment Aware**: Configured to run natively on MySQL for local development, and automatically shifts into PostgreSQL inside production containers.
- **Modern UI Suite**: Features a totally overhauled interface leveraging fluid CSS variables, native hover states, and a premium aesthetic.
- **Global Dark Mode**: Includes an automated dark-theme widget that relies on browser `localStorage` ensuring your aesthetic preference follows you safely across page reloads.

## 💻 Tech Stack
- **Backend Framework**: Java Spring Boot 3.5.x
- **Security Provider**: Spring Security (Encrypted BCrypt Authentication)
- **Database Framework**: Spring Data JPA / Hibernate (MySQL Local | PostgreSQL Cloud)
- **Template Engine**: Thymeleaf templating
- **Deployment**: Configured for Docker & Render Cloud Blueprints

## 🛠 Running Locally

If you are developing or testing this project natively on your laptop:

1. Ensure your local **MySQL Server** is online (Port `3306`) with credentials matching application properties (typically User: `root`, Pass: `root123`).
2. Utilize Maven to trigger the server boot process:
```bash
./mvnw spring-boot:run
```
3. Open your browser and navigate to exactly `http://localhost:8080/`. You will automatically be greeted with the authentication screen.

## ☁️ Deploying Live to the Internet

This repository is engineered to deploy seamlessly via Render Blueprints with zero manual database wireups required.

1. Create a free account at [Render.com](https://render.com).
2. Look for **Blueprints** on your dashboard and hit **New Blueprint**.
3. Connect your GitHub repository.
4. Ensure the *Blueprint Path* field specifically says `render.yaml`.
5. Hit Apply! Render will automatically:
   - Boot a fresh PostgreSQL Database cluster.
   - Run Maven, compress the backend, and package the Docker container natively.
   - Serve your dashboard instantly across the public internet securely connecting it!
