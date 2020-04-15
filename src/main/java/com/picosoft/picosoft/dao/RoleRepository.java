package com.picosoft.picosoft.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.picosoft.picosoft.module.Role;

@Repository
/**
 * 
 * @author X270
 *@see JpaRepository<Role, Long>
 */
public interface RoleRepository extends JpaRepository<Role, Long>{

	
}
