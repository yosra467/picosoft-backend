package com.picosoft.picosoft.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.picosoft.picosoft.dao.RoleRepository;
import com.picosoft.picosoft.module.Role;
/**
 * 
 * @author X270
 *
 */
@RestController
@Transactional
@RequestMapping(value = "api/user")
public class RoleController {
	@Autowired
	RoleRepository roleRepository;
	/**
	 * le responsable_rh peut consulter la liste des roles
	 * @return roleRepository.findAll()
	 */
	@PreAuthorize("hasAuthority('admin')")
	@GetMapping(value="/allRole")
    public List<Role> getAllRole(){
        return roleRepository.findAll();
    }
	/**
	 * 
	 * @param id
	 * @return ResponseEntity.ok().body(role)
	 * @throws Exception
	 */
	@PreAuthorize("hasAuthority('admin')")
	@GetMapping(value="/role/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Long id) throws Exception{
        Role role = roleRepository.findById(id).orElseThrow(()->new Exception("Le role n'existe pas"));
        return ResponseEntity.ok().body(role);
    }
	/**
	 * le responsable_rh peut ajouter un role
	 * @param role
	 * @return roleRepository.save(role)
	 */
	@PreAuthorize("hasAuthority('admin')")
	@PostMapping(value="/ajouterRole")
    public Role AjouterRole(@Valid @RequestBody Role role){
        return roleRepository.save(role);
    }
	/**
	 * le responsable_rh peut modifier un role
	 * @param id
	 * @param roleDetails
	 * @return ResponseEntity.ok(role)
	 * @throws Exception
	 */
	@PreAuthorize("hasAuthority('admin')")
	@PutMapping(value="/updateRole/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable Long id, @Valid @RequestBody Role roleDetails) throws Exception{
        Role role = roleRepository.findById(id).orElseThrow(()->new Exception("Le role n'existe pas"));
        role.setRole(roleDetails.getRole());
        roleRepository.save(role);
        return ResponseEntity.ok(role);
    }
	/**
	 * le responsable_rh peut supprimer un role
	 * @param id
	 * @return response
	 * @throws Exception
	 */
	@PreAuthorize("hasAuthority('admin')")
	@DeleteMapping(value="/deleteRole/{id}")
    public Map<String,Boolean> deleteRole(@PathVariable Long id) throws Exception{
        Role role = roleRepository.findById(id).orElseThrow(()->new Exception("Le role n'existe pas"));
        roleRepository.delete(role);
        Map<String,Boolean> response = new HashMap<>();
        response.put("Le role est supprimé!",Boolean.TRUE);
        return response;
    }

}
