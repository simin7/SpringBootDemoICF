package com.springbootdemo.ICF.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootdemo.ICF.dao.DependantsDAO;
import com.springbootdemo.ICF.dao.EmployeeDAO;
import com.springbootdemo.ICF.model.Dependants;
import com.springbootdemo.ICF.model.Employee;

@RestController
@RequestMapping("/company")
public class DependantsController {
	
	@Autowired
	DependantsDAO dependantsDAO;
	
	

	/* to save a dependant*/
	@PostMapping("/dependants")
	public Dependants createDependant(@Valid @RequestBody Dependants dep) {
		return dependantsDAO.save(dep);
	}
	
	/*get all dependants*/
	@GetMapping("/dependants")
	public List<Dependants> getAllDependants(){
		return dependantsDAO.findAll();
	}
	
	/*get employee by dept name*/
	@GetMapping("/dependants/{id}")
	public ResponseEntity<Dependants> getDependantsById(@PathVariable(value="id") Long id){
		
		
		Dependants dep=dependantsDAO.findOne(id);
		
		if(id==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(dep);
		
	}
	
	
	/*update an dependant by dep id*/
	@PutMapping("/dependants/{id}")
	public ResponseEntity<Dependants> updateDependants(@PathVariable(value="id") Long id,@Valid @RequestBody Dependants depDetails){
		
		Dependants dep=dependantsDAO.findOne(id);
		if(dep==null) {
			return ResponseEntity.notFound().build();
		}
		
		dep.setFname(depDetails.getFname());
		dep.setLname(depDetails.getLname());
		dep.setId(depDetails.getId());
		dep.setDOB(depDetails.getDOB());
		dep.setGender(depDetails.getGender());
		


		Dependants updateDependants=dependantsDAO.save(dep);
		return ResponseEntity.ok().body(updateDependants);
		
	}
	
	/*Delete a dependant*/
	@DeleteMapping("/dependants/{id}")
	public ResponseEntity<Dependants> deleteDependant(@PathVariable(value="id") Long id){
		
		Dependants dep=dependantsDAO.findOne(id);
		if(dep==null) {
			return ResponseEntity.notFound().build();
		}
		dependantsDAO.delete(dep);
		
		return ResponseEntity.ok().build();
		
		
	}
	

}

