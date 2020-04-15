package com.picosoft.picosoft.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.picosoft.picosoft.module.User;

@Repository
/**
 * 
 * @author X270
 *@see JpaRepository<User, Long>
 */
public interface UserRepository extends JpaRepository<User, Long> {
	/**
	 * 
	 * @param nom
	 * 
	 */
	public List<User> findByNom(String nom);
/**
 * 
 * @param email

 */
	public User findByEmail(String email);
/**
 * 
 * @param prenom
 
 */
	public List<User> findByPrenom(String prenom);

}
