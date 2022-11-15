package com.springboot.imaginnoavte.spring.employeeinterface.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.imaginnoavte.spring.employeeDTO.Employee;
import com.springboot.imaginnoavte.spring.employeeDTO.EmployeeTable;
import com.springboot.imaginnoavte.spring.employeeinterface.EmployeeTaxCal;



@Service
public class EmployeeTacCalClass implements EmployeeTaxCal{

	@Autowired
	private EmployeeRepository emplRepo;
	
	@Override
	public int taxToBePaid(float salary) {
		int taxPaid = 0;
		if (salary > 250000 ) {
			taxPaid = (taxPaid + (250000 * 5 / 100));
		}
		if (salary > 500000) {
			taxPaid = (taxPaid + (500000 * 10 / 100));
		}
		if (salary > 1000000) {
			taxPaid = (taxPaid + (1000000 * 15 / 100));
		}
		return taxPaid;
	}

	@Override
	public Employee save(Employee employee) {
		EmployeeTable employeeTable = getByEmpId(employee.getEmployeeID());
		if (employeeTable != null) {
			employeeTable.setEmailId(employee.getEmailId());
			employeeTable.setDateOfJoining(employee.getDateOfJoining());
			employeeTable.setFirstName(employee.getFirstName());
			employeeTable.setLastName(employee.getLastName());
			employeeTable.setSalary(employee.getSalary());
			employeeTable.setPhoneNo(employee.getPhoneNo());
		}
		else {
			employeeTable = new EmployeeTable();
			employeeTable.setEmployeeID(employee.getEmployeeID());
			employeeTable.setEmailId(employee.getEmailId());
			employeeTable.setDateOfJoining(employee.getDateOfJoining());
			employeeTable.setFirstName(employee.getFirstName());
			employeeTable.setLastName(employee.getLastName());
			employeeTable.setSalary(employee.getSalary());
			employeeTable.setPhoneNo(employee.getPhoneNo());
		}
			emplRepo.save(employeeTable);
			return employee;
	
	}

	@Override
	public EmployeeTable getByEmpId(String empId) {
		if(empId!=null) {
			return emplRepo.findByEmployeeID(empId);
		}
		return null;
	}

	

}
