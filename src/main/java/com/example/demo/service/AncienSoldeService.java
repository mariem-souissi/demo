package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import com.example.demo.entities.AncienSolde;
import com.example.demo.interfaces.IAncienSoldeService;
import com.example.demo.repositories.AncienSoldeRepository;



@Service
public class AncienSoldeService implements IAncienSoldeService{
	@Autowired
	AncienSoldeRepository ancienSoldeRepository;
	

	@Override
	public List<AncienSolde> retrieveAllAncienSoldes() {
		
		return ancienSoldeRepository.findAll() ;
	}

	@Override
	public AncienSolde addAncienSolde(AncienSolde a) {
		
		return ancienSoldeRepository.save(a);
	}

	
	public void deleteAncienSolde(String id) {
        ancienSoldeRepository.deleteById(id);
    }

	

	@Override
	public AncienSolde retrieveAncienSoldeById(String id) {
	    return ancienSoldeRepository.findById(id).orElseThrow(() -> new RuntimeException("AncienSolde not found"));
	}


	@Override
	public List<AncienSolde> getAncienSolde(String id, LocalDate date) {
	    /*Optional<AncienSolde> optionalAncienSolde = ancienSoldeRepository.findByIdAndDate(id, date);
	    return optionalAncienSolde.map(Collections::singletonList).orElse(new ArrayList<>()); */
		return null;
	}

	

	@Override
	public List<AncienSolde> getAncienSoldeByDate(LocalDate date) {
	    // Retrieve AncienSolde by date
	    //return ancienSoldeRepository.findByDate(date);
		return null;
	}

	@Override
	public AncienSolde findByIdAndDate(String id, LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}

	
	


}
