package com.example.NGOWebApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.NGOWebApp.model.DynamicInfo;
import com.example.NGOWebApp.model.DynamicVision;
import com.example.NGOWebApp.repository.DynamicInfoRepository;

@Service
public class DynamicInfoService {

	@Autowired
	private DynamicInfoRepository dynamicInfoRepository;
	
	public DynamicInfo getLatestVision() {
        return dynamicInfoRepository.findTopByOrderByIdDesc();
    }
	
	public List<DynamicInfo> getAllInfos() {
        return dynamicInfoRepository.findAll(); 
    }
	
	public void deleteInfo(Long id) {
        dynamicInfoRepository.deleteById(id);
    }

	
	public void saveInfo(DynamicInfo dynamicInfo) {
        dynamicInfoRepository.save(dynamicInfo);
    }
}
