package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Complement;
import com.example.demo.interfaces.IComplementService;
import com.example.demo.repositories.ComplementRepository;


@Service
public class ComplementService implements IComplementService{
	@Autowired
	ComplementRepository complementRepository;

	
	@Override
	public List<Complement> retrieveAllComplements() {
		
		return complementRepository.findAll() ;
	}

	@Override
	public Complement addComplement(Complement a) {
		
		return complementRepository.save(a);
	}

	
	public void deleteComplement(String id) {
        complementRepository.deleteById(id);
    }
	
	@Override
	public Complement retrieveComplementById(String id) {
		
		return complementRepository.findById(id).orElseThrow(() -> new RuntimeException("Complement not found"));
	}
	
	


}
