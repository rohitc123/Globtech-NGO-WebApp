package com.example.NGOWebApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.NGOWebApp.model.DynamicVision;

public interface DynamicVisionRepository extends JpaRepository<DynamicVision,Long> {
	 DynamicVision findTopByOrderByIdDesc();
}
