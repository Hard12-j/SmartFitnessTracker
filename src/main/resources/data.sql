-- Fix: ensure AUTO_INCREMENT is set on id columns (tables were created without it)
ALTER TABLE diet_plan     MODIFY COLUMN id BIGINT NOT NULL AUTO_INCREMENT;
ALTER TABLE exercise_plan MODIFY COLUMN id BIGINT NOT NULL AUTO_INCREMENT;
