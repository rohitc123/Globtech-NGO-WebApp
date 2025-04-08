package com.example.NGOWebApp.controller;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.NGOWebApp.model.ProgramCard;
import com.example.NGOWebApp.service.ProgramCardService;

@Controller
public class AdminController {

    @Autowired
    private ProgramCardService programCardService;

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    // Define the absolute upload directory
    private static final String UPLOAD_DIR = System.getProperty("user.dir") + "/src/main/resources/static/uploads/";
    @GetMapping("/admin/dashboard")
    public String adminDashboard(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        model.addAttribute("username", userDetails.getUsername());
        return "admin/AdminDashboard";
    }

    @GetMapping("/admin/add-card")
    public String showAddCardForm(Model model) {
        model.addAttribute("card", new ProgramCard());
        return "admin/programcard";
    }

    @PostMapping("/admin/save-card")
    public String saveCard(@RequestParam("imageFile") MultipartFile file,
                           @ModelAttribute("card") ProgramCard card,
                           Model model) {
        try {
            logger.info("Uploading file: {}", file.getOriginalFilename());

            // Validate file
            if (file.isEmpty()) {
                model.addAttribute("error", "Please upload an image file.");
                return "admin/programcard";
            }

            // Ensure the upload directory exists
            File uploadPath = new File(UPLOAD_DIR);
            if (!uploadPath.exists()) {
                uploadPath.mkdirs();
            }

            // Generate unique filename
            String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
            Path filePath = Paths.get(UPLOAD_DIR, fileName);

            // Save the file immediately
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
            }
            logger.info("File saved at: {}", filePath);

            // Set relative path for frontend
            card.setImagePath("/uploads/" + fileName);

            // Save to database and force commit
            programCardService.saveAndFlush(card);
            logger.info("Card saved successfully!");

            // Provide feedback to the user
            model.addAttribute("message", "Card saved successfully!");

            // Redirect to dashboard
            return "redirect:/admin/dashboard";
        } catch (Exception e) {
            logger.error("Failed to save card", e);
            model.addAttribute("error", "Failed to upload image: " + e.getMessage());
            return "admin/programcard";
        }
    }
}
