package com.springbootdemo.ICF.repository;

import com.springbootdemo.ICF.model.Dependants;
import com.springbootdemo.ICF.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface DependantsRepository extends JpaRepository<Dependants, Long> {

}