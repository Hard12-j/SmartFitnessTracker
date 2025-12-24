package com.wellnest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Resolve Frontend folder robustly for different run locations (Backend/, Backend/target/, root)
        File currentDir = new File("").getAbsoluteFile();
        File frontendDir = tryResolveFrontend(currentDir);
        String frontendPath = frontendDir.getAbsolutePath() + File.separator;
        
        // Serve static files from Frontend folder
        registry.addResourceHandler("/**")
                .addResourceLocations("file:" + frontendPath)
                .addResourceLocations("classpath:/static/");
    }

    private File tryResolveFrontend(File currentDir) {
        // Try sibling ../Frontend (when running from Backend)
        File candidate = new File(currentDir, ".." + File.separator + "Frontend");
        if (candidate.exists() && candidate.isDirectory()) {
            return candidate;
        }
        // Try parent/Frontend (when running from project root or target)
        File parent = currentDir.getParentFile();
        if (parent != null) {
            File sibling = new File(parent, "Frontend");
            if (sibling.exists() && sibling.isDirectory()) {
                return sibling;
            }
        }
        // Fallback to currentDir/Frontend (for custom setups)
        File local = new File(currentDir, "Frontend");
        return local.exists() && local.isDirectory() ? local : currentDir;
    }
}

