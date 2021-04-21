package com.springbootdemo.ICF.repository;

import com.springbootdemo.ICF.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}




