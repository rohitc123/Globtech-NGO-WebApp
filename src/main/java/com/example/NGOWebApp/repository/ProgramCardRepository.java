package com.example.NGOWebApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.NGOWebApp.model.ProgramCard;

public interface ProgramCardRepository extends JpaRepository<ProgramCard,Long> {

}
