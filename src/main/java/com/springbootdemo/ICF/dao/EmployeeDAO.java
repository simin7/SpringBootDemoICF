package com.springbootdemo.ICF.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootdemo.ICF.model.Employee;
import com.springbootdemo.ICF.repository.EmployeeRepository;

@Service
public class EmployeeDAO {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	/* to save an employee*/
	
	public Employee save(Employee emp)
	{
		return employeeRepository.save(emp);
	}
	
	
	/* to search all the employees*/
	
	public List<Employee> findAll()
	{
		return employeeRepository.findAll();
	}
	
	
	/* to get an employee*/
	
	public Employee findOne(Long empid)
	{
		return employeeRepository.findOne(empid);
	}
	
	
	/* to delete an employee*/
	
	public void delete(Employee emp)
	{
		employeeRepository.delete(emp);
	}
	
	

}
