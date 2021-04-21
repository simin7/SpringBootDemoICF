package com.springbootdemo.ICF.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootdemo.ICF.model.Dependants;
import com.springbootdemo.ICF.model.EducationalQualification;
import com.springbootdemo.ICF.repository.DependantsRepository;
import com.springbootdemo.ICF.repository.EducationalQualificationRepository;

@Service
public class EducationalQualificationDAO {

	
	@Autowired
	EducationalQualificationRepository educationalQualificationalRepository;
	
	
	public EducationalQualification save(EducationalQualification edu)
	{
		return educationalQualificationalRepository.save(edu);
	}
	
	

	
	public List<EducationalQualification> findAll()
	{
		return educationalQualificationalRepository.findAll();
	}
	
	
	
	
	public EducationalQualification findOne(Long type)
	{
		return educationalQualificationalRepository.findOne(type);
	}
	
	
	
	public void delete(EducationalQualification edu)
	{
		educationalQualificationalRepository.delete(edu);
	}
}
