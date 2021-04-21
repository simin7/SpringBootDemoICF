package com.springbootdemo.ICF.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class Dependants {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotBlank 
	private String fname;
	
	@NotBlank
	private String lname;
	
	@NotNull
	private Date DOB;
	
	@NotBlank
	private String gender;
	
	@NotBlank
	private String relationship;

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	
	
}
