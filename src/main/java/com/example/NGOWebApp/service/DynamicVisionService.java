package com.example.NGOWebApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.NGOWebApp.model.DynamicVision;
import com.example.NGOWebApp.repository.DynamicVisionRepository;

@Service
public class DynamicVisionService {

	@Autowired
    private DynamicVisionRepository visionRepository;

    // Fetch the latest vision statement
    public DynamicVision getLatestVision() {
        return visionRepository.findTopByOrderByIdDesc();
    }

    // Save or update vision statement
    public void saveVision(DynamicVision dynamicVision) {
        visionRepository.save(dynamicVision);
    }
}
