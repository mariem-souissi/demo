package com.example.demo.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.*;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/upload")
public class FileUploadController {
	
	@Autowired
	FileUploadService fileUploadService;
	@PostMapping(value = "/uploadFile", consumes = "multipart/form-data")
	  public String handleFileUpload(@RequestParam("file") MultipartFile file) {
		
	
            String classificationResult = fileUploadService.processUploadedFile(file);
           return classificationResult;
        
	  }
	

}
