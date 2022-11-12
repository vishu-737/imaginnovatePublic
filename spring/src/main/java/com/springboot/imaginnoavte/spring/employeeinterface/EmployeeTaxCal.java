package com.springboot.imaginnoavte.spring.employeeinterface;

import com.springboot.imaginnoavte.spring.employeeDTO.Employee;
import com.springboot.imaginnoavte.spring.employeeDTO.EmployeeTable;

public interface EmployeeTaxCal {
	
	public int taxToBePaid(float salary);

	public Employee save(Employee employee);

	public EmployeeTable getByEmpId(String empId);

}
