package com.example.NGOWebApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.NGOWebApp.model.DynamicInfo;
import com.example.NGOWebApp.service.DynamicInfoService;


@Controller
public class DynamicInfoController {

	@Autowired
	private DynamicInfoService dynamicInfoService;
	
	@GetMapping("/admin/aboutus/addInfo")
    public String getCompanyInfo(Model model) {
		model.addAttribute("dynamicInfo", new DynamicInfo()); 
		List<DynamicInfo> allInfos = dynamicInfoService.getAllInfos();
        model.addAttribute("allInfos", allInfos);
    	
        return "admin/addInfo";
    }
	
	@PostMapping("/admin/aboutus/addInfo")
    public String saveInformation(@ModelAttribute DynamicInfo dynamicInfo) {
    	dynamicInfoService.saveInfo(dynamicInfo);
        return "redirect:/aboutus/who-we-are"; 
    }
	
	@PostMapping("/admin/aboutus/deleteInfo/{id}")
    public String deleteInfo(@PathVariable Long id) {
        dynamicInfoService.deleteInfo(id);
        return "redirect:/admin/aboutus/addInfo"; // Refresh the page
    }
}
