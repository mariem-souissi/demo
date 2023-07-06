package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.demo.entities.*;
@Entity
@Table(name = "complement")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Complement {
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
	@Column(name="code_operation_interne",length =4)
	String code_operation_interne ;
	
	@Column(name="zoneG",length = 1)
	String ZoneG;
	@Column(name="code_op_intban",length = 2)
	String code_op_intban ;
	@Column(name="date_compt_op",length = 6)
	int date_compt_op ;
	@Column(name="zoneK",length = 5)
	String ZoneK ;
	@Column(name="qual_zone_infcom")
	String qual_zone_infcom ;
	@Column(name="inf_complementaires")
	String inf_complementaires ;
	@Column(name="zoneN",length = 2)
	String ZoneN ;
	@ManyToOne
    private Mouvement mouvement;

}
