package com.example.demo.interfaces;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.entities.Mouvement;

public interface IMouvementService {
	List<Mouvement> retrieveAllMouvements();
	Mouvement addMouvement(Mouvement a);
	void deleteMouvement(String id);

	Mouvement retrieveMouvementById(String id);
	public List<Mouvement> getMouvement(String idCategory,LocalDate date);
	public List<Mouvement> getMouvementByDate(LocalDate date);

}
