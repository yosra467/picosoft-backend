package com.picosoft.picosoft.module;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
/**
 * 
 * @author X270
 * 
 */
public class RelationPoli_JF implements Serializable{
	/**
	 * @see politique
	 */
	@Id
	@ManyToOne
private Politique politique;
	/**
	 * @see jourFerie
	 */
	@Id
	@ManyToOne
	private JourFerie jourferie;
	

}
