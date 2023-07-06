package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.AncienSolde;
import com.example.demo.service.AncienSoldeService;



@RestController
@RequestMapping("/ancienSolde")
public class AncienSoldeController {
	@Autowired
	AncienSoldeService ancienSoldeService;
	@GetMapping("/getALlAncienSoldes")
	@ResponseBody
	public List<AncienSolde> retrieveAllAncienSoldes() {
		
		return ancienSoldeService.retrieveAllAncienSoldes();
	}

	@PostMapping("/saveAncienSolde")
	@ResponseBody
	public AncienSolde addAncienSolde(AncienSolde a) {
	
		return ancienSoldeService.addAncienSolde(a);
	}

	@DeleteMapping("/delete-AncienSolde/{numero_compte}")
	@ResponseBody
	public void deleteAncienSolde(String id) {
		ancienSoldeService.deleteAncienSolde(id);
    }

	
	@GetMapping("/get-AncSolde/{numero_compte}")
	@ResponseBody
	
	public AncienSolde retrieveAncienSoldeById(@PathVariable("numero_compte") String id) {
	    return ancienSoldeService.retrieveAncienSoldeById(id);
	}

	@GetMapping("/get-AncienSoldesIdDate/{numero_compte}")
	@ResponseBody
	
	public List<AncienSolde> getAncienSolde(@PathVariable("numero_compte") String id,@PathVariable("date_anc_solde") LocalDate date) {
	    /*Optional<AncienSolde> optionalAncienSolde = ancienSoldeRepository.findByIdAndDate(id, date);
	    return optionalAncienSolde.map(Collections::singletonList).orElse(new ArrayList<>()); */
		return null;
	}

	

	
	/*public List<AncienSolde> getAncienSoldeByDate(LocalDate date) {
	    // Retrieve AncienSolde by date
	    //return ancienSoldeRepository.findByDate(date);
		return null;
	}

	
	public AncienSolde findByIdAndDate(@PathVariable("numero_compte") String id,@PathVariable("date_anc_solde") LocalDate date) {
		// TODO Auto-generated method stub
		return ancienSoldeService.findByIdAndDate(id, date);
	}*/


}
