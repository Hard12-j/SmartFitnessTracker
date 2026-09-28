# WellNest — Smart Health & Fitness Companion

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.4-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Spring Security](https://img.shields.io/badge/Spring%20Security-6.x-green.svg)](https://spring.io/projects/spring-security)
[![MySQL](https://img.shields.io/badge/MySQL-8.0-blue.svg)](https://www.mysql.com/)
[![Docker](https://img.shields.io/badge/Docker-Ready-2496ED.svg)](https://www.docker.com/)
[![WebSocket](https://img.shields.io/badge/WebSocket-STOMP-blueviolet.svg)](https://spring.io/guides/gs/messaging-stomp-websocket/)


> A full-stack health and fitness management platform that integrates daily activity tracking, nutrition and hydration logging, data-driven analytics, smart trainer matching, and real-time communication into a unified ecosystem.

---

## 🌟 Overview

**WellNest (Smart Health Tracker)** eliminates the fragmentation of modern wellness tracking. Instead of juggling separate apps for calorie counting, workout logs, sleep tracking, and trainer consultations, WellNest unifies these workflows under one role-based platform designed for **Users**, **Certified Trainers**, and **Admins**.

---

## ✨ Key Features

### 🔐 1. Authentication & Role-Based Access Control (RBAC)
- **Role Separation**: Tailored experiences for `ROLE_USER`, `ROLE_TRAINER`, and `ROLE_ADMIN`.
- **Secure Onboarding**: BCrypt password hashing, session security, and role-restricted dashboard routing.
- **Forgot Password & OTP Recovery**: Automated verification email with timed One-Time Passwords (OTP) via Spring Mail.

### 🏋️‍♂️ 2. Workout & Calorie Tracker
- **Comprehensive Logging**: Track cardio and strength workouts with exercise type, duration, and intensity.
- **Calorie Estimation**: Automated calculation of calories burned based on exercise type and intensity.
- **Session History**: Historical logs enabling users to analyze endurance and strength progression over time.

### 🥗 3. Nutrition, Hydration & Sleep Habits
- **Meal Diary**: Categorized tracking across Breakfast, Lunch, Dinner, and Snacks.
- **Hydration Monitor**: Daily water intake logger measured against dynamic hydration targets.
- **Sleep Quality Log**: Sleep duration tracking to uncover correlations between rest and physical output.

### ⚖️ 4. Integrated BMI Calculator & Health Guidance
- **Instant Health Metric**: Computes Body Mass Index (BMI) dynamically from user profile height and weight.
- **Category Classification**: Classifies status into *Underweight*, *Normal*, *Overweight*, or *Obese*.
- **Tailored Guidance**: Displays instant actionable advice based on BMI category.

### 📊 5. Interactive Analytics Dashboard (Chart.js)
- **Activity Trends**: Visual weekly graphs tracking workout frequency vs. total duration.
- **Energy Balance**: Comparative analytics plotting *Calories Consumed* vs. *Calories Burned*.
- **Habit Correlations**: Overlays sleep and hydration data against daily performance trends.

### 🤝 6. Smart Trainer Matching & Plan Assignment
- **Goal-Based Matching Algorithm**: Recommends certified trainers based on the user's explicit goals (Fat Loss, Muscle Gain, Endurance, General Fitness).
- **Trainer Dashboard**: Dedicated portal for trainers to inspect matched students, track client progress, and assign customized workout and diet plans.

### 💬 7. Real-Time Chat (WebSocket + STOMP)
- **Instant Messaging**: Low-latency 1-on-1 messaging between clients and their assigned trainers.
- **STOMP Protocol over SockJS**: Persistent connection fallbacks with message history storage.

### 📰 8. Community Fitness Blog & Articles
- **Expert Articles**: Trainers and admins publish structured wellness, nutrition, and exercise articles.
- **Community Engagement**: Users can read, like, and comment on health discussions.

---

## 🏗️ System Architecture

```
                                +---------------------------+
                                |  Browser / Client (UI)    |
                                |  Thymeleaf + Chart.js     |
                                |  SockJS + STOMP Client    |
                                +-------------+-------------+
                                              |
                                      HTTP / WebSocket
                                              |
                                              v
+-----------------------------------------------------------------------------------+
| Spring Boot 3.3.4 Application                                                     |
|                                                                                   |
|  [ Controllers ] <---> [ Spring Security ]                                        |
|  • Auth & Profile        (Role-based access: USER, TRAINER, ADMIN)                |
|  • Workout & Meal                                                                 |
|  • BMI & Analytics                                                                |
|  • Trainer Dashboard                                                              |
|  • ChatController (WebSocket Message Broker: /app, /topic, /queue)                |
|                                                                                   |
|  [ Service Layer ]                                                                |
|  • Matching Engine  • BMI Calculator  • Email / OTP Service  • Analytics Service   |
|                                                                                   |
|  [ Data Access Layer (Spring Data JPA / Hibernate) ]                              |
|  • UserRepository   • WorkoutRepository   • MealRepository   • ChatRepository     |
+------------------------------------------+----------------------------------------+
                                           |
                                      JDBC / MySQL
                                           |
                                           v
                              +-------------------------+
                              |   MySQL 8.0 Database    |
                              |   (Tables & Relations)  |
                              +-------------------------+
```

---

## 🛠️ Technology Stack

| Layer | Technologies |
|---|---|
| **Backend Framework** | Java 21, Spring Boot 3.3.4 |
| **Security & Auth** | Spring Security 6, BCrypt, Role-Based Access Control (RBAC) |
| **Persistence / ORM** | Spring Data JPA, Hibernate, HikariCP |
| **Database** | MySQL 8.0 |
| **Real-Time Messaging** | Spring WebSocket, STOMP Messaging, SockJS |
| **Frontend / Templating** | Thymeleaf, HTML5, Vanilla CSS3, JavaScript |
| **Data Visualization** | Chart.js, Bootstrap Icons |
| **Build & Packaging** | Maven (mvnw wrapper), Multi-stage Docker |
| **Utilities & Mailing** | Lombok 1.18.38, Jakarta Validation, Spring Mail (JavaMailSender) |

---

## 📁 Project Structure

```
SmartHealthTracker/
├── src/
│   ├── main/
│   │   ├── java/com/healthTracker/implementation/
│   │   │   ├── config/            # SecurityConfig, WebSocketConfig, MailConfig
│   │   │   ├── controller/        # Auth, Workout, Meal, BMI, Chat, Trainer controllers
│   │   │   ├── dto/               # Data Transfer Objects (UserDto, PasswordReset, etc.)
│   │   │   ├── model/             # JPA Entities (User, Role, Workout, Meal, ChatMessage)
│   │   │   ├── repository/        # Spring Data JPA repositories
│   │   │   └── service/           # Business logic & service implementations
│   │   └── resources/
│   │       ├── static/            # CSS, JS, Chart scripts, assets
│   │       ├── templates/         # Thymeleaf views (dashboards, forms, chat, blog)
│   │       ├── application.properties # Main application configuration
│   │       └── data.sql           # Initial seed data
├── docker-compose.yml             # Local multi-container setup (App + MySQL)
├── Dockerfile                     # Multi-stage production container build
├── pom.xml                        # Maven dependencies & build definitions
└── README.md                      # Project documentation
```

---

## 🚀 Quick Start Guide

### Prerequisites
- **Java 21** or later
- **Maven 3.8+** (or use the included `./mvnw`)
- **MySQL 8.0+** (or **Docker** & **Docker Compose**)

---

### Option 1: Run with Docker Compose (Recommended)

The easiest way to run the entire stack (Spring Boot App + MySQL database) with a single command:

```bash
# Clone the repository
git clone https://github.com/Hard12-j/SmartFitnessTracker.git
cd SmartFitnessTracker

# Build and start services
docker-compose up --build
```

- Application will be live at: **`http://localhost:8081`**
- MySQL container will be running on port `3306`.

To stop the containers:
```bash
docker-compose down
```

---

### Option 2: Local Manual Setup

#### 1. Setup MySQL Database
Start your local MySQL service and create the database:
```sql
CREATE DATABASE jwtexample3;
```

#### 2. Configure Environment Variables
You can configure credentials via system environment variables or edit `src/main/resources/application.properties`:

```properties
JDBC_DATABASE_URL=jdbc:mysql://localhost:3306/jwtexample3?createDatabaseIfNotExist=true
MYSQL_USER=root
MYSQL_PASSWORD=your_mysql_password
PORT=8081
```

#### 3. Build and Run

```bash
# Windows
.\mvnw.cmd clean spring-boot:run

# macOS / Linux
./mvnw clean spring-boot:run
```

Access the application in your browser at **`http://localhost:8081`**.

---

## ⚙️ Configuration Reference

| Environment Variable | Default Value | Description |
|---|---|---|
| `PORT` | `8081` | Web server port |
| `JDBC_DATABASE_URL` | `jdbc:mysql://localhost:3306/jwtexample3` | Full JDBC database URL |
| `MYSQL_USER` | `root` | Database username |
| `MYSQL_PASSWORD` | `root` | Database password |
| `MAIL_HOST` | `smtp.gmail.com` | SMTP host for OTP verification emails |
| `MAIL_PORT` | `587` | SMTP port |
| `MAIL_USERNAME` | *(empty)* | Email account address for sending OTPs |
| `MAIL_PASSWORD` | *(empty)* | Email app password / credential |

---

## 🔑 Default Roles & Access

| Role | Accessible Routes | Primary Purpose |
|---|---|---|
| **`ROLE_USER`** | `/welcome`, `/profile`, `/workout`, `/meal`, `/daily-log`, `/bmi`, `/trainer-matching`, `/chat` | Track fitness metrics, browse articles, message matched trainer |
| **`ROLE_TRAINER`** | `/trainer-dashboard`, `/assign-plan`, `/chat`, `/articles` | Guide assigned students, issue workout/diet plans, write articles |
| **`ROLE_ADMIN`** | `/admin-dashboard`, `/admin-stats`, `/article-create` | System administration, platform statistics, article moderation |

---

## 📄 License

This project is licensed under the **MIT License**.

