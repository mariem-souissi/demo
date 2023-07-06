package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Mouvement;
import com.example.demo.interfaces.IMouvementService;
import com.example.demo.repositories.MouvementRepository;


@Service
public class MouvementService implements IMouvementService{
	@Autowired
	MouvementRepository mouvementRepository;

	@Override
	public List<Mouvement> retrieveAllMouvements() {
		
		return mouvementRepository.findAll() ;
	}

	@Override
	public Mouvement addMouvement(Mouvement a) {
		
		return mouvementRepository.save(a);
	}

	@Override
	public void deleteMouvement(String id) {
		
		mouvementRepository.deleteById(id);
	}

	

	@Override
	public Mouvement retrieveMouvementById(String id) {
		
		return mouvementRepository.findById(id).orElseThrow(() -> new RuntimeException("Mouvement not found"));
	}

	@Override
	public List<Mouvement> getMouvement(String id, LocalDate date) {
		
		return null;
	}

	@Override
	public List<Mouvement> getMouvementByDate(LocalDate date) {
		
		return null;
	}

}
