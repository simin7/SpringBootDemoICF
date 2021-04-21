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
import com.springbootdemo.ICF.dao.EducationalQualificationDAO;
import com.springbootdemo.ICF.model.Dependants;
import com.springbootdemo.ICF.model.EducationalQualification;

@RestController
@RequestMapping("/company")
public class EducationalQualificationController {
	
	@Autowired
	EducationalQualificationDAO eduDAO;
	
	

	
	@PostMapping("/educational")
	public EducationalQualification createEduQual(@Valid @RequestBody EducationalQualification edu) {
		return eduDAO.save(edu);
	}
	
	
	@GetMapping("/educational")
	public List<EducationalQualification> getAllEdu(){
		return eduDAO.findAll();
	}
	
	@GetMapping("/educational/{type}")
	public ResponseEntity<EducationalQualification> getEduQualByType(@PathVariable(value="type") Long type){
		
		
		EducationalQualification edu=eduDAO.findOne(type);
		
		if(type==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(edu);
		
	}
	
	
	
	@PutMapping("/educational/{type}")
	public ResponseEntity<EducationalQualification> updateEduQual(@PathVariable(value="type") Long type,@Valid @RequestBody EducationalQualification eduDetails){
		
		EducationalQualification edu=eduDAO.findOne(type);
		if(edu==null) {
			return ResponseEntity.notFound().build();
		}
		
		edu.setAddress(eduDetails.getAddress());
		edu.setEndDate(eduDetails.getEndDate());
		edu.setInstitution(eduDetails.getInstitution());
		edu.setPercentage(eduDetails.getPercentage());
		edu.setStartDate(eduDetails.getStartDate());
		edu.setType(eduDetails.getType());

		


		EducationalQualification updateEducationalQualification=eduDAO.save(edu);
		return ResponseEntity.ok().body(updateEducationalQualification);
		
	}
	

	@DeleteMapping("/educational/{type}")
	public ResponseEntity<EducationalQualification> deleteEduQual(@PathVariable(value="type") Long type){
		
		EducationalQualification edu=eduDAO.findOne(type);
		if(edu==null) {
			return ResponseEntity.notFound().build();
		}
		eduDAO.delete(edu);
		
		return ResponseEntity.ok().build();
		
		
	}
}
	

