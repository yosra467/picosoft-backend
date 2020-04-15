package com.picosoft.picosoft.module;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
/**
 * 
 * @author X270
 *
 */
public class HoraireJour {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/**
	 * @id id
	 * @see user#getId()
	 * @see user#setId(long) 
	 * @see user#getnomJour()
	 * @see user#setnomJour(string)
	 * @see user#gethDebut1()
	 * @see user#sethDebut1(string)
	 * @see user#gethFin1()
	 * @see user#sethFin1(string)
	 * @see user#gethDebut2()
	 * @see user#sethDebut2(string)
	 * @see user#gethFin2()
	 * @see user#sethFin2(string)
	 */
	private Long id;
	
	private String nomJour;
	private String hDebut1;
	private String hFin1;
	private String hDebut2;
	private String hFin2;
	/**
	 * @see Horaire
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore

	private Horaire horaire;

}
