# WellNest Platform - Health Blog & Trainer Matching System

A comprehensive health and fitness platform built with Spring Boot, featuring a Health Blog module and Smart Trainer Matching System.

## 🚀 Features

### Health Blog Module
- ✅ Create, edit, and delete blog posts
- ✅ Category-based filtering (Nutrition, Workout, Mental Health, Tips)
- ✅ Like and comment functionality
- ✅ User-friendly blog listing and detail pages
- ✅ Responsive design with modern UI

### Trainer Matching System
- ✅ Smart matching algorithm based on fitness goals and preferences
- ✅ Trainer profiles with specializations and availability
- ✅ User fitness profile management
- ✅ Match score calculation and ranking
- ✅ Contact information for trainers

## 🛠️ Tech Stack

- **Backend**: Java 17, Spring Boot 3.2.0
- **Database**: MySQL
- **Frontend**: HTML, CSS, JavaScript
- **Build Tool**: Maven

## 📋 Prerequisites

- Java 17 or higher
- Maven 3.6+
- MySQL 8.0+
- Modern web browser

## 📁 Project Structure

```
wellnest-platform/
├── Backend/                    # Spring Boot Backend
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/wellnest/
│   │   │   │   ├── blog/          # Blog module
│   │   │   │   │   ├── entity/
│   │   │   │   │   ├── repository/
│   │   │   │   │   ├── service/
│   │   │   │   │   ├── controller/
│   │   │   │   │   └── dto/
│   │   │   │   ├── trainer/       # Trainer module
│   │   │   │   │   ├── entity/
│   │   │   │   │   ├── repository/
│   │   │   │   │   ├── service/
│   │   │   │   │   ├── controller/
│   │   │   │   │   └── dto/
│   │   │   │   ├── config/        # Configuration
│   │   │   │   └── WellNestApplication.java
│   │   │   └── resources/
│   │   │       └── application.properties
│   └── pom.xml
├── Frontend/                   # Frontend Files
│   ├── index.html             # Dashboard/Home page
│   ├── blogs.html             # Blog listing
│   ├── blog-detail.html       # Blog detail view
│   ├── blog-create.html       # Create/edit blog form
│   ├── trainer-matching.html  # Trainer matching page
│   ├── profile.html           # User profile form
│   ├── css/
│   │   └── style.css          # Main stylesheet
│   └── js/
│       └── app.js             # JavaScript functions
├── database/
│   └── schema.sql             # Database schema
└── README.md
```

## 🔧 Setup Instructions

### 1. Database Setup

1. Create MySQL database:
```sql
CREATE DATABASE wellnest_db;
```

2. Run the schema file (optional - Hibernate will create tables automatically):
```bash
mysql -u root -p wellnest_db < database/schema.sql
```

3. Update database credentials in `Backend/src/main/resources/application.properties`:
```properties
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### 2. Build and Run Backend

1. Navigate to Backend folder:
```bash
cd Backend
```

2. Build the project:
```bash
mvn clean install
```

3. Run the Spring Boot application:
```bash
mvn spring-boot:run
```

Or run the main class:
```bash
java -jar target/wellnest-platform-1.0.0.jar
```

4. Access the application:
   - Frontend: http://localhost:8080/index.html
   - API Base: http://localhost:8080/api

## 🔌 API Endpoints

### Blog APIs
- `GET /api/blogs` - Get all blogs (optional: `?category=NUTRITION`)
- `GET /api/blogs/{id}` - Get blog by ID
- `POST /api/blogs` - Create new blog
- `PUT /api/blogs/{id}` - Update blog
- `DELETE /api/blogs/{id}` - Delete blog
- `GET /api/blogs/{id}/comments` - Get comments for a blog
- `POST /api/blogs/{id}/comments` - Add comment
- `PUT /api/blogs/comments/{commentId}` - Update comment
- `DELETE /api/blogs/comments/{commentId}` - Delete comment
- `POST /api/blogs/{id}/like` - Toggle like
- `GET /api/blogs/{id}/like-status?userName=xxx` - Check like status

### Trainer APIs
- `GET /api/trainers` - Get all trainers
- `GET /api/trainers/{id}` - Get trainer by ID
- `GET /api/trainers/match/{userName}` - Find matching trainers
- `GET /api/trainers/profiles/{userName}` - Get user profile
- `POST /api/trainers/profiles` - Save/update user profile

## 🎨 Frontend Pages

1. **index.html** - Dashboard/home page
2. **blogs.html** - Blog listing with category filter
3. **blog-detail.html** - Individual blog post with comments
4. **blog-create.html** - Create/edit blog post form
5. **trainer-matching.html** - Trainer listing and matching
6. **profile.html** - User fitness profile form

## 🎯 Usage Guide

### Creating a Blog Post
1. Navigate to "Health Blog" → "Create New Post"
2. Fill in title, category, content, and optional image URL
3. Click "Publish Post"

### Finding a Trainer
1. Go to "My Profile" and complete your fitness profile
2. Navigate to "Find Trainer"
3. Click "Find My Match" to get personalized recommendations
4. View trainer details and contact information

### Interacting with Blogs
- Click the heart icon to like/unlike a post
- Scroll to comments section to add/view comments
- Edit or delete your own comments

## 🧪 Testing

The application includes sample data in `database/schema.sql`:
- 5 sample trainers with specializations
- 5 sample blog posts
- Trainer availability schedules

## 🎨 Theme

The application uses a modern, health-focused theme with:
- Primary color: Green (#2d8659) - representing health and wellness
- Secondary color: Blue (#4a90e2) - representing trust and professionalism
- Responsive design for mobile and desktop
- Clean, user-friendly interface

## 📝 Notes

- User names are stored in browser localStorage
- Set your user name when prompted or via "Change User" link
- Blog posts require a user name to be set
- Trainer matching requires a completed fitness profile
- Frontend files are served from the `Frontend/` folder
- Backend runs from the `Backend/` folder

## 🔒 Security Notes

For production deployment, consider:
- Adding authentication and authorization
- Implementing CSRF protection
- Securing API endpoints
- Adding input validation and sanitization
- Using HTTPS

## 📄 License

This project is created for educational purposes.

## 👥 Support

For issues or questions, please refer to the project documentation or contact the development team.

---

**WellNest Platform** - Your Health & Fitness Companion 💚
