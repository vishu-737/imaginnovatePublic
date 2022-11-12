package com.springboot.imaginnoavte.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.imaginnoavte.spring.employeeDTO.EmployeeTable;
import java.lang.String;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeTable, String> {


   List<EmployeeTable> findByEmployeeID(String employeeid);
	
}
