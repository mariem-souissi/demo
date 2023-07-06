package com.example.demo.entities;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.demo.entities.*;

@Entity
@Table(name = "mouvement")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mouvement {
	public Mouvement(String string, String codeBanque, String codeGuichet, String codeDevise, int nbDecMnt,
			String numCompte, String codeOpInt, String zoneG2, String codeOpInterBan, int dateComptaOp,
			String codeMotifRejet, int dateValeur, String libelle2, String zoneN2, int numEcriture,
			String indExonerationCom, String indIndisponibilte, String mntMouvement, String zoneS) {
		// TODO Auto-generated constructor stub
	}
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
	@Column(name="code_op_int",length = 4)
    String code_op_int ;
	
	@Column(name="zoneG",length = 1)
	String zoneG;
	
	@Column(name="code_op_intban",length = 2)
    String code_op_intban  ;
	@Column(name="date_compt_op",length = 6)
	@DateTimeFormat(pattern = "ddMMyy")
	private LocalDate date_compt_op;
	
    
	@Column(name="code_motif_rejet",length = 2)
    String code_motif_rejet ;
	@Column(name="date_val",length = 6)
    int date_val ;
	@Column(name="libelle",length = 31)
    String libelle ;
	@Column(name="zoneN",length = 2)
    String zoneN ;
	@Column(name="numero_ecr",length = 7)
    int numero_ecr ;
	@Column(name="indice_exo_com_mvt_compte",length = 1)
    String indice_exo_com_mvt_compte;
	@Column(name="indice_indisponibilite",length = 1)
    String indice_indisponibilite;
	@Column(name="mont_mvt",length = 14)
	String mont_mvt;
	@Column(name="zone_ref",length = 16)
    String zone_ref ;
	@ManyToOne
	AncienSolde ancienSolde;
	@OneToMany(fetch=FetchType.LAZY,mappedBy = "mouvement")
    private List<Complement> complements;

}
