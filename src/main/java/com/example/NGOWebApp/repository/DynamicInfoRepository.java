package com.example.NGOWebApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.NGOWebApp.model.DynamicInfo;

public interface DynamicInfoRepository extends JpaRepository<DynamicInfo,Long> {

	DynamicInfo findTopByOrderByIdDesc();
}
