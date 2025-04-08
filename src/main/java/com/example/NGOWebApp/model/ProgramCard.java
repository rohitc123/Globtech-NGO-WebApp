package com.example.NGOWebApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProgramCard {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String heading;
    private String imagePath;
    private String description;
    private String pageUrl;
    
    public ProgramCard() {}

	public ProgramCard(Long id, String heading, String imagePath, String description, String pageUrl) {
		super();
		this.id = id;
		this.heading = heading;
		this.imagePath = imagePath;
		this.description = description;
		this.pageUrl = pageUrl;
	}

	 public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getHeading() {
	        return heading;
	    }

	    public void setHeading(String heading) {
	        this.heading = heading;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public String getPageUrl() {
	        return pageUrl;
	    }

	    public void setPageUrl(String pageUrl) {
	        this.pageUrl = pageUrl;
	    }

	    public String getImagePath() {
	        return imagePath;
	    }

	    public void setImagePath(String imagePath) {
	        this.imagePath = imagePath;
	    }
    
}
