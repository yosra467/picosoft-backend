package com.picosoft.picosoft.module;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


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
public class RelationAppPolitique implements Serializable{
	@Id
	@ManyToOne
	/**
	 * @see ApplicationHoraire
	 */

	private ApplicationHoraire appHoraire;
	@Id
	@ManyToOne
/**
 * @see Politique 
 */
	private Politique politique;

}
