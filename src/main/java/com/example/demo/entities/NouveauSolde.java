package com.example.demo.entities;





import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.demo.entities.*;

@Entity
@Table(name="nouveau_solde")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NouveauSolde {
	@Column(name="code_enregistrement",length = 2)
	int code_enregistrement;
	@Column(name="code_banque",length = 5)
	String code_banque;
	@Column(name="code_guichet",length = 5)
	String code_guichet ;
	@Column(name="code_devise",length = 3)
	String code_devise ;
	@Column(name="nombre_dec_mont",length = 1)
	int nombre_dec_mont;
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="numero_compte",length = 11)
	String numero_compte;
	
	@Column(name="date_nouv_solde",length = 6)
	@DateTimeFormat(pattern = "ddMMyy")
	private LocalDate date_nouv_solde;
	
	@Column(name="mont_nouv_solde",length = 14)
	String mont_nouv_solde ;
	@Column(name="ZoneC",length = 4)
	String ZoneC;
	@Column(name="ZoneG",length = 1)
	String ZoneG;
	@Column(name="ZoneI",length = 2)
	String ZoneI ;
	@Column(name="ZoneK",length = 50)
	String ZoneK ;
	@Column(name="ZoneM",length = 16)
	String ZoneM;
	@OneToOne(mappedBy = "nouveauSolde")
    private AncienSolde ancienSolde;
	

}
