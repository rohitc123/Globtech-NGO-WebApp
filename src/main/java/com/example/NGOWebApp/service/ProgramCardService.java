package com.example.NGOWebApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.NGOWebApp.model.ProgramCard;
import com.example.NGOWebApp.repository.ProgramCardRepository;

@Service
public class ProgramCardService {

	@Autowired
	private ProgramCardRepository programCardRepository;
	
	
	
	public ProgramCard saveAndFlush(ProgramCard card) {
        return programCardRepository.saveAndFlush(card);
    }
	
	 public List<ProgramCard> getAllCards() {
	        return programCardRepository.findAll();
	    }
}
