-- WellNest Database Schema
-- Database: wellnest_db

-- Blogs Table
CREATE TABLE IF NOT EXISTS blogs (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    category VARCHAR(100) NOT NULL,
    content TEXT NOT NULL,
    author_name VARCHAR(255) NOT NULL,
    author_type VARCHAR(50) NOT NULL, -- USER, TRAINER, ADMIN
    published_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    image_url VARCHAR(500),
    status VARCHAR(50) DEFAULT 'PUBLISHED', -- PUBLISHED, PENDING, REJECTED
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Blog Comments Table
CREATE TABLE IF NOT EXISTS blog_comments (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    blog_id BIGINT NOT NULL,
    user_name VARCHAR(255) NOT NULL,
    comment_text TEXT NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (blog_id) REFERENCES blogs(id) ON DELETE CASCADE
);

-- Blog Likes Table
CREATE TABLE IF NOT EXISTS blog_likes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    blog_id BIGINT NOT NULL,
    user_name VARCHAR(255) NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    UNIQUE KEY unique_like (blog_id, user_name),
    FOREIGN KEY (blog_id) REFERENCES blogs(id) ON DELETE CASCADE
);

-- Trainers Table
CREATE TABLE IF NOT EXISTS trainers (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    phone VARCHAR(50),
    experience_years INT DEFAULT 0,
    rating DECIMAL(3,2) DEFAULT 0.00,
    profile_summary TEXT,
    location VARCHAR(255),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Trainer Specializations Table
CREATE TABLE IF NOT EXISTS trainer_specializations (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    trainer_id BIGINT NOT NULL,
    specialization VARCHAR(100) NOT NULL,
    FOREIGN KEY (trainer_id) REFERENCES trainers(id) ON DELETE CASCADE
);

-- Trainer Availability Table
CREATE TABLE IF NOT EXISTS trainer_availability (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    trainer_id BIGINT NOT NULL,
    day_of_week VARCHAR(20) NOT NULL, -- MONDAY, TUESDAY, etc.
    start_time TIME NOT NULL,
    end_time TIME NOT NULL,
    FOREIGN KEY (trainer_id) REFERENCES trainers(id) ON DELETE CASCADE
);

-- User Fitness Profiles Table (for matching)
CREATE TABLE IF NOT EXISTS user_fitness_profiles (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(255) NOT NULL,
    fitness_goal VARCHAR(100), -- WEIGHT_LOSS, MUSCLE_GAIN, GENERAL_FITNESS, etc.
    preferred_workout_type VARCHAR(100), -- CARDIO, STRENGTH, YOGA, etc.
    age INT,
    experience_level VARCHAR(50), -- BEGINNER, INTERMEDIATE, ADVANCED
    preferred_training_style VARCHAR(100),
    location VARCHAR(255),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Insert Sample Trainers Data
INSERT INTO trainers (name, email, phone, experience_years, rating, profile_summary, location) VALUES
('Sarah Johnson', 'sarah.j@wellnest.com', '+1-555-0101', 8, 4.8, 'Certified personal trainer specializing in weight loss and cardio training. Passionate about helping clients achieve their fitness goals.', 'New York'),
('Mike Chen', 'mike.chen@wellnest.com', '+1-555-0102', 12, 4.9, 'Expert strength trainer with over 12 years of experience. Focus on muscle building and body transformation.', 'Los Angeles'),
('Emma Williams', 'emma.w@wellnest.com', '+1-555-0103', 6, 4.7, 'Yoga and mindfulness instructor. Specializes in flexibility, stress relief, and holistic wellness.', 'San Francisco'),
('David Martinez', 'david.m@wellnest.com', '+1-555-0104', 10, 4.8, 'HIIT and functional training specialist. Helps clients build endurance and strength.', 'Chicago'),
('Lisa Anderson', 'lisa.a@wellnest.com', '+1-555-0105', 7, 4.6, 'Nutrition and fitness coach. Combines diet planning with personalized workout routines.', 'Boston');

-- Insert Trainer Specializations
INSERT INTO trainer_specializations (trainer_id, specialization) VALUES
(1, 'WEIGHT_LOSS'), (1, 'CARDIO'), (1, 'HIIT'),
(2, 'MUSCLE_GAIN'), (2, 'STRENGTH'), (2, 'BODYBUILDING'),
(3, 'YOGA'), (3, 'FLEXIBILITY'), (3, 'MENTAL_HEALTH'),
(4, 'HIIT'), (4, 'CARDIO'), (4, 'FUNCTIONAL_TRAINING'),
(5, 'NUTRITION'), (5, 'WEIGHT_LOSS'), (5, 'GENERAL_FITNESS');

-- Insert Trainer Availability
INSERT INTO trainer_availability (trainer_id, day_of_week, start_time, end_time) VALUES
(1, 'MONDAY', '09:00:00', '17:00:00'),
(1, 'WEDNESDAY', '09:00:00', '17:00:00'),
(1, 'FRIDAY', '09:00:00', '17:00:00'),
(2, 'TUESDAY', '10:00:00', '18:00:00'),
(2, 'THURSDAY', '10:00:00', '18:00:00'),
(2, 'SATURDAY', '08:00:00', '14:00:00'),
(3, 'MONDAY', '08:00:00', '16:00:00'),
(3, 'WEDNESDAY', '08:00:00', '16:00:00'),
(3, 'FRIDAY', '08:00:00', '16:00:00'),
(4, 'TUESDAY', '07:00:00', '15:00:00'),
(4, 'THURSDAY', '07:00:00', '15:00:00'),
(4, 'SATURDAY', '09:00:00', '13:00:00'),
(5, 'MONDAY', '09:00:00', '17:00:00'),
(5, 'TUESDAY', '09:00:00', '17:00:00'),
(5, 'WEDNESDAY', '09:00:00', '17:00:00');

-- Insert Sample Blog Posts
INSERT INTO blogs (title, category, content, author_name, author_type, image_url) VALUES
('10 Tips for Effective Weight Loss', 'NUTRITION', 'Weight loss is a journey that requires dedication and the right approach. Here are 10 proven tips to help you achieve your goals...', 'Sarah Johnson', 'TRAINER', 'https://images.unsplash.com/photo-1490645935967-10de6ba17061'),
('Building Muscle: A Complete Guide', 'WORKOUT', 'Muscle building requires a combination of proper nutrition, progressive overload, and adequate recovery. Learn the fundamentals...', 'Mike Chen', 'TRAINER', 'https://images.unsplash.com/photo-1571019613454-1cb2f99b2d8b'),
('The Benefits of Yoga for Mental Health', 'MENTAL_HEALTH', 'Yoga is not just physical exercise; it''s a practice that connects mind, body, and spirit. Discover how yoga can improve your mental wellbeing...', 'Emma Williams', 'TRAINER', 'https://images.unsplash.com/photo-1506126613408-eca07ce68773'),
('HIIT Workouts: Maximize Your Time', 'WORKOUT', 'High-Intensity Interval Training (HIIT) is one of the most efficient ways to burn calories and improve cardiovascular health...', 'David Martinez', 'TRAINER', 'https://images.unsplash.com/photo-1517836357463-d25dfeac3438'),
('Nutrition Basics for Beginners', 'NUTRITION', 'Understanding nutrition is the foundation of a healthy lifestyle. Learn about macronutrients, micronutrients, and meal planning...', 'Lisa Anderson', 'TRAINER', 'https://images.unsplash.com/photo-1490645935967-10de6ba17061');


