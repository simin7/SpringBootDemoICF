package com.springbootdemo.ICF.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class EducationalQualification {

	@NotNull
	private Long type;
	
	@NotNull
	private Long percentage;
	
	@NotNull 
	private Date startDate;
	
	@NotNull
	private Date endDate;
	
	@NotBlank
	private String institution;
	
	@NotBlank
	private String address;
	
	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	public Long getPercentage() {
		return percentage;
	}

	public void setPercentage(Long percentage) {
		this.percentage = percentage;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	
	
}
