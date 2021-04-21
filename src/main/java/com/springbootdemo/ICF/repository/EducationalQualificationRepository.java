package com.springbootdemo.ICF.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootdemo.ICF.model.Dependants;
import com.springbootdemo.ICF.model.EducationalQualification;

public interface EducationalQualificationRepository extends JpaRepository<EducationalQualification, Long> {

}
