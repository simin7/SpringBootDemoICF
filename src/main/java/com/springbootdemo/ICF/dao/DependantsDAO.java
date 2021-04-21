package com.springbootdemo.ICF.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootdemo.ICF.model.Dependants;

import com.springbootdemo.ICF.repository.DependantsRepository;

@Service
public class DependantsDAO {

	@Autowired
	DependantsRepository dependantsRepository;
	
	/* to save a dependant*/
	
	public Dependants save(Dependants dep)
	{
		return dependantsRepository.save(dep);
	}
	
	
	/* to search all the dependants*/
	
	public List<Dependants> findAll()
	{
		return dependantsRepository.findAll();
	}
	
	
	/* to get a dependant*/
	
	public Dependants findOne(Long id)
	{
		return dependantsRepository.findOne(id);
	}
	
	
	/* to delete a dependant*/
	
	public void delete(Dependants dep)
	{
		dependantsRepository.delete(dep);
	}
	
}
