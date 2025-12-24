# Quick Setup Guide

## Project Structure

```
wellnest-platform/
├── Backend/          # Spring Boot Backend Application
├── Frontend/         # Frontend HTML/CSS/JS Files
└── database/         # Database Schema
```

## Running the Application

### Step 1: Setup Database
1. Create MySQL database: `wellnest_db`
2. Update credentials in `Backend/src/main/resources/application.properties`

### Step 2: Run Backend
```bash
cd Backend
mvn spring-boot:run
```

### Step 3: Access Application
- Open browser: http://localhost:8080/index.html
- API Base: http://localhost:8080/api

## Important Notes

- **Backend** folder contains all Java source code and Spring Boot configuration
- **Frontend** folder contains all HTML, CSS, and JavaScript files
- The backend automatically serves static files from the Frontend folder
- Make sure to run the backend from the `Backend` directory
- The old `src` folder can be deleted (it's been moved to Backend)

## Development

- Edit frontend files in `Frontend/` folder
- Edit backend files in `Backend/src/main/java/` folder
- Changes to frontend files are served immediately (no restart needed)
- Changes to backend files require restart


