package com.example.NGOWebApp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DynamicInfo {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(columnDefinition = "TEXT")
    private String companyinfo;
    
    public DynamicInfo(){}

	public DynamicInfo(Long id, String companyinfo) {
		super();
		this.id = id;
		this.companyinfo = companyinfo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyinfo() {
		return companyinfo;
	}

	public void setCompanyinfo(String companyinfo) {
		this.companyinfo = companyinfo;
	}
    
    
}
