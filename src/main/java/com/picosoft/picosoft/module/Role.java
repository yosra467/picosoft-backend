package com.picosoft.picosoft.module;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
/**
 * 
 * @author X270
 *
 */
public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	/**
	 * les attributs de la classe role sont les suivants :
	 * @id id 
	 * @see user#getId()
	 * @see user#setId(long) 
	 * @see user#getRole()
	 * @see user#setRole(string)

	 */
	private Long id;
	
	@Column(length=60)
	private String role;
	
	/**
	 * un role peut etre affecté à plusieurs utilisateurs
	 */
	@OneToMany(mappedBy="role", cascade=CascadeType.ALL)
	@JsonIgnore
	
	private List<User> user;
	/*public Role(String role) {
		this.role=role;
	}*/

}