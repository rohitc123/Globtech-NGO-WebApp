package com.example.NGOWebApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DynamicVision {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String visionText;
	    
	    public DynamicVision() {}

		public DynamicVision(Long id, String visionText) {
			super();
			this.id = id;
			this.visionText = visionText;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getVisionText() {
			return visionText;
		}

		public void setVisionText(String visionText) {
			this.visionText = visionText;
		}
	    
}
