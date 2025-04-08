package com.example.NGOWebApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.NGOWebApp.model.DynamicInfo;
import com.example.NGOWebApp.model.DynamicVision;
import com.example.NGOWebApp.model.ProgramCard;
import com.example.NGOWebApp.service.DynamicInfoService;
import com.example.NGOWebApp.service.DynamicVisionService;
import com.example.NGOWebApp.service.ProgramCardService;

import jakarta.servlet.http.HttpSession;

@Controller
public class NavbarController {
	
	@Autowired
    private DynamicVisionService dynamicVisionService;
	
	@Autowired
	 private  ProgramCardService programCardService;
	
	@Autowired
	private DynamicInfoService dynamicInfoService;
	
	 @GetMapping("/")
	    public String home() {	
	        return "home";
	   }
	    
	 @GetMapping({"/home"})
	 public String homePage(Model model) {
	     List<ProgramCard> cards = programCardService.getAllCards();
	     model.addAttribute("cards", cards); 
	     return "home"; 
	 }


	    
	    @GetMapping("/aboutus/who-we-are")
	    public String whoWeAre(Model model) {
	    	DynamicInfo latestInfo = dynamicInfoService.getLatestVision();
	    	model.addAttribute("dynamicInfo", latestInfo); 
	        return "aboutus/who-we-are"; 
	    }
	    
	    @GetMapping("/aboutus/vision")
	    public String vision(Model model) {
	    	DynamicVision dynamicVision = dynamicVisionService.getLatestVision(); // Fetch data from service
	        model.addAttribute("dynamicVision", dynamicVision);
	        return "aboutus/vision";
	    }


	    @GetMapping("/aboutus/mission")
	    public String mission() {
	        return "aboutus/mission";
	    }

	    @GetMapping("/aboutus/ourvalues")
	    public String ourValues() {
	        return "aboutus/ourvalues";
	    }

	    @GetMapping("/aboutus/our-approach")
	    public String ourApproach() {
	        return "aboutus/our-approach";
	    }

	    @GetMapping("/OurPrograms/coding-on-wheels")
	    public String codingOnWheels() {
	        return "OurPrograms/CodingOnWheels";
	    }
	    
	    @GetMapping("/OurPrograms/coding-edu-in-school")
	    public String coes() {
	        return "OurPrograms/CEOS";
	    }
	    
	    @GetMapping("/OurPrograms/Women-Empoverment")
	    public String womenEmpoverment() {
	        return "OurPrograms/WomanEmpoverment";
	    }
	    
	    @GetMapping("/OurPrograms/livelihoods")
	    public String livehoods() {
	        return "OurPrograms/Livelihoods";
	    }
	    
	    @GetMapping("/Campaign/padhobhi-padhaobhi")
	    public String padhobhi() {
	    	return "Campaign/padhobhi";
	    }
	    
	    @GetMapping("/Campaign/corporate-tranning")
	    public String corporateTranning() {
	    	return "Campaign/CorporateTranning";
	    }
	    
	    @GetMapping("/GetInvolved/payroll-Giving")
	    public String payrollGiving() {
	    	return "GetInvolved/payroll";
	    }
	    
	    @GetMapping("/GetInvolved/support-for")
	    public String supportPage() {
	    	return "GetInvolved/SupportFor";
	    }
	    
	    
}
