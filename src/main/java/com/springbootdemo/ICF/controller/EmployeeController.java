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

import com.springbootdemo.ICF.dao.EmployeeDAO;
import com.springbootdemo.ICF.model.Employee;

@RestController
@RequestMapping("/company")
public class EmployeeController {
	
	@Autowired
	EmployeeDAO employeeDAO;
	
	

	/* to save an employee*/
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee emp) {
		return employeeDAO.save(emp);
	}
	
	/*get all employees*/
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeDAO.findAll();
	}
	
	/*get employee by empid*/
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="id") Long empid){
		
		Employee emp=employeeDAO.findOne(empid);
		
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);
		
	}
	
	
	/*update an employee by empid*/
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value="id") Long empid,@Valid @RequestBody Employee empDetails){
		
		Employee emp=employeeDAO.findOne(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		
		emp.setFname(empDetails.getFname());
		emp.setLname(empDetails.getLname());
		emp.setEmpid(empDetails.getEmpid());
		emp.setStartDate(empDetails.getStartDate());
		emp.setDesignation(empDetails.getDesignation());
		emp.setDepartment(empDetails.getDepartment());
		emp.setEndDate(empDetails.getEndDate());
		emp.setStatus(empDetails.getStatus());
		emp.setDOB(empDetails.getDOB());
		emp.setRepManager(empDetails.getRepManager());
		emp.setGender(empDetails.getGender());
		emp.setBloodGroup(empDetails.getBloodGroup());
		emp.setAddress(empDetails.getAddress());


		Employee updateEmployee=employeeDAO.save(emp);
		return ResponseEntity.ok().body(updateEmployee);
		
	}
	
	/*Delete an employee*/
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value="id") Long empid){
		
		Employee emp=employeeDAO.findOne(empid);
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		employeeDAO.delete(emp);
		
		return ResponseEntity.ok().build();
		
		
	}
	

}
