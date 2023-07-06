package com.example.demo.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.AncienSolde;
import com.example.demo.entities.Complement;
import com.example.demo.entities.Mouvement;
import com.example.demo.entities.NouveauSolde;

import Exception.StorageException;

import com.example.demo.entities.*;
@Service
public class FileUploadService {

@Autowired
AncienSoldeService ancienSoldeService;
ComplementService complementService;
MouvementService mouvementService;
NouveauSoldeService nouveauSoldeService;

/*private final Path fileStorageLocation ;
public String FileStorageService(FileUploadEntity fileUploadentity) {
    this.fileStorageLocation = Paths.get(fileUploadentity.getUploadDir())
            .toAbsolutePath().normalize();

    try {
        Files.createDirectories(this.fileStorageLocation);
    } catch (Exception ex) {
        throw new StorageException("Could not create the directory where the uploaded files will be stored.", ex);
    }
   
}*/
    public String processUploadedFile(MultipartFile file) {
 
    	try {
    		Scanner input = new Scanner(new File("CFONB120.txt"));
    		while (input.hasNextLine()) {
	        	String str=input.nextLine();
				System.out.println(str);
				String codeEnr= str.substring(0, 2);
				System.out.println(codeEnr);
				switch (codeEnr) {
			    case "01":
			        classifyOperation1(str);
			        System.out.println("ancien solde ajouté");
			        break;
			    case "04":
			        classifyOperation2(str);
			        System.out.println("mouvement ajouté");
			        break;
			    case "05":
			        classifyOperation3(str);
			        System.out.println("complement ajouté");
			        break;
			    case "07":
			        classifyOperation4(str);
			        System.out.println("nouveau solde ajouté");
			        break;
			    default:
			        // Handle unknown codeEnr value
			        break;
			}

				}
    		
    		input.close();
    		
        } catch (IOException e) {
            e.printStackTrace();
            // Handle any exceptions that occur during file processing
        }
    	return "pr";
        
    }
    private AncienSolde classifyOperation1(String str) {
    	String codeBanque = str.substring(2, 7);
		String zoneC = str.substring(7, 11);


		String codeGuichet = str.substring(11, 16);
		String codeDevise = str.substring(16, 19);

		int nbDecMnt = Integer.parseInt(str.substring(19, 20));
		String zoneG = str.substring(20, 21);

		String numCompte = str.substring(21, 32);
		String zoneI = str.substring(32, 34);

		int dateAncSolde = Integer.parseInt(str.substring(34, 40));
		String zoneK =str.substring(40, 90);

		String mntAncSolde = str.substring(90, 104);
		String zoneM = str.substring(104);
		System.out.println(str.substring(0, 2)+codeBanque+zoneC+codeGuichet+codeDevise+nbDecMnt+zoneG+numCompte+zoneI+dateAncSolde+zoneK+mntAncSolde+zoneM);
		AncienSolde ancienSolde = new AncienSolde(str.substring(0, 2), codeBanque, codeGuichet,codeDevise,nbDecMnt, numCompte,dateAncSolde,mntAncSolde,zoneC,zoneG,zoneI,zoneK,zoneM);
		
        ancienSoldeService.addAncienSolde(ancienSolde);
        // Perform classification logic and populate the ancienSolde object with relevant data
        return ancienSolde;
    }
    private Mouvement classifyOperation2(String str) {
    	String codeBanque =str.substring(3, 7);
		String codeOpInt = str.substring(7, 11);
		String codeGuichet = str.substring(11, 16);
		String codeDevise = str.substring(16, 19);

		int nbDecMnt = Integer.parseInt(str.substring(19, 20));
		String zoneG = str.substring(20, 21);

		String numCompte = str.substring(21, 32);
		String codeOpInterBan = str.substring(32, 34);
		int dateComptaOp = Integer.parseInt(str.substring(34, 40));
		String codeMotifRejet= str.substring(40, 42);
		int dateValeur = Integer.parseInt(str.substring(42, 48));

		String libelle = str.substring(48, 79);
		String zoneN = str.substring(79, 81);
		int numEcriture = Integer.parseInt(str.substring(81, 88));
		String indExonerationCom = str.substring(88, 89);
		String indIndisponibilte = str.substring(89, 90);

		String mntMouvement = str.substring(90, 104);
		String zoneS = str.substring(104);
		MouvementService mouvementService = new MouvementService();
		Mouvement mouvement = new Mouvement(str.substring(0, 2),codeBanque,codeGuichet,codeDevise,nbDecMnt,numCompte,codeOpInt,zoneG,codeOpInterBan,dateComptaOp,codeMotifRejet,dateValeur,libelle,zoneN,numEcriture,indExonerationCom,indIndisponibilte,mntMouvement,zoneS);

    	mouvementService.addMouvement(mouvement);
        // Perform classification logic and populate the ancienSolde object with relevant data
        return mouvement;
    }
    private Complement classifyOperation3(String str) {
    	String codeBanque = str.substring(3, 7);
		String codeOpInt = str.substring(7, 11);
		String codeGuichet = str.substring(11, 16);
		
		String codeDevise = str.substring(16, 19);

		int nbDecMnt = Integer.parseInt(str.substring(19, 20));
		String zoneG = str.substring(20, 21);

		String numCompte = str.substring(21, 32);
		String codeOpInterBan = str.substring(32, 34);
		int dateComptaOp = Integer.parseInt(str.substring(34, 40));
		String zoneK = str.substring(40, 45);
		String qualInfCompl = str.substring(45, 48);
		String infCompl = str.substring(48, 118);
		String zoneN = str.substring(118);
		

    	Complement complement = new Complement();
    	complementService.addComplement(complement);
        // Perform classification logic and populate the ancienSolde object with relevant data
        return complement;
    }
    private NouveauSolde classifyOperation4(String str) {
    	String codeBanque = str.substring(3, 7);
		String zoneC = str.substring(7, 11);


		String codeGuichet = str.substring(11, 16);
		String codeDevise = str.substring(16, 19);

		int nbDecMnt = Integer.parseInt(str.substring(19, 20));
		String zoneG = str.substring(20, 21);

		String numCompte = str.substring(21, 32);
		String zoneI = str.substring(32, 34);
		
		int dateNouveauSolde = Integer.parseInt(str.substring(34, 40));
		String zoneK = str.substring(40, 90);

		String mntNouveauSolde = str.substring(90, 104);
		String zoneM = str.substring(104);
    	NouveauSolde nouveauSolde = new NouveauSolde();
    	nouveauSoldeService.addNouveauSolde(nouveauSolde);
        // Perform classification logic and populate the ancienSolde object with relevant data
        return nouveauSolde;
    }
    
    
}
