package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.AncienSolde;
import com.example.demo.service.AncienSoldeService;



@RestController
@RequestMapping("/test")
public class TestController {
	AncienSoldeService ancienSoldeService;
	
	
	@GetMapping("/get")
	@ResponseBody
	public String test() {
		return "Hello World";
	}
	//public List<AncienSolde> getSolde() {
	//	return ancienSoldeService.retrieveAllAncienSoldes();
	//}

}