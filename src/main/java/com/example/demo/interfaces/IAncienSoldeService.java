package com.example.demo.interfaces;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.entities.AncienSolde;



public interface IAncienSoldeService {
	List<AncienSolde> retrieveAllAncienSoldes();
	AncienSolde addAncienSolde(AncienSolde a);
	void deleteAncienSolde(String id);
	AncienSolde findByIdAndDate(String id, LocalDate date);
	
	AncienSolde retrieveAncienSoldeById(String id);
	public List<AncienSolde> getAncienSolde(String id,LocalDate date);
	public List<AncienSolde> getAncienSoldeByDate(LocalDate date);

}
