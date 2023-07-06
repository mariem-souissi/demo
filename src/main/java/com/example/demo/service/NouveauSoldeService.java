package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.NouveauSolde;
import com.example.demo.interfaces.INouveauSoldeService;
import com.example.demo.repositories.NouveauSoldeRepository;

@Service
public class NouveauSoldeService implements INouveauSoldeService{
	@Autowired
	NouveauSoldeRepository nouveauSoldeRepository;

	@Override
	public List<NouveauSolde> retrieveAllNouveauSoldes() {
		
		return nouveauSoldeRepository.findAll() ;
	}

	@Override
	public NouveauSolde addNouveauSolde(NouveauSolde a) {
		
		return nouveauSoldeRepository.save(a);
	}

	@Override
	public void deleteNouveauSolde(String id) {
		nouveauSoldeRepository.deleteById(id);
		
	}

	
	@Override
	public NouveauSolde retrieveNouveauSoldeById(String id) {
		
		return nouveauSoldeRepository.findById(id).orElseThrow(() -> new RuntimeException("NouveauSolde not found"));
	}

	@Override
	public List<NouveauSolde> getNouveauSolde(String idCategory, LocalDate date) {
		
		return null;
	}

	@Override
	public List<NouveauSolde> getNouveauSoldeByDate(LocalDate date) {
		
		return null;
	}

}
