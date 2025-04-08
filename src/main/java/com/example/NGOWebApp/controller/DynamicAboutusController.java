package com.example.NGOWebApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.NGOWebApp.model.DynamicVision;
import com.example.NGOWebApp.service.DynamicVisionService;

@Controller
public class DynamicAboutusController {

	@Autowired
    private DynamicVisionService dynamicVisionService;

    // Load the vision page with the latest vision statement
    @GetMapping("/admin/aboutus/addvision")
    public String getVision(Model model) {
    	model.addAttribute("dynamicVision", new DynamicVision()); 
        return "admin/addvision";
    }

    // Save the vision statement from the form
    @PostMapping("/admin/aboutus/addvision")
    public String saveVision(@ModelAttribute DynamicVision dynamicVision) {
    	dynamicVisionService.saveVision(dynamicVision);
        return "redirect:/aboutus/vision"; // Redirect to the vision page after saving
    }
}