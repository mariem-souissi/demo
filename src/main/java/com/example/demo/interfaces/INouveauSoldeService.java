package com.example.demo.interfaces;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.entities.NouveauSolde;

public interface INouveauSoldeService {
	List<NouveauSolde> retrieveAllNouveauSoldes();
	NouveauSolde addNouveauSolde(NouveauSolde a);
	void deleteNouveauSolde(String id);
	
	NouveauSolde retrieveNouveauSoldeById(String id);
	public List<NouveauSolde> getNouveauSolde(String idCategory,LocalDate date);
	public List<NouveauSolde> getNouveauSoldeByDate(LocalDate date);

}
