package com.springboot.imaginnoavte.spring.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.validation.Valid;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.imaginnoavte.spring.employeeDTO.Employee;
import com.springboot.imaginnoavte.spring.employeeDTO.EmployeeDTO;
import com.springboot.imaginnoavte.spring.employeeDTO.EmployeeTable;
import com.springboot.imaginnoavte.spring.employeeinterface.EmployeeTaxCal;




@RestController
@RequestMapping("/api/imaginnovate")
public class EmployeeController {
	
	@Autowired
	private EmployeeTaxCal employeeTaxCal;
	
	
	
	@PostMapping("/saveEmployeeDetails")
	public String saveEmployeeDetails(@Valid @RequestBody Employee employee){
		Employee empl = employeeTaxCal.save(employee);
		if(empl!=null) {
			return empl.getEmployeeID();
		}
		return null;
	}
	
	
	@SuppressWarnings("deprecation")
	@GetMapping("/v1/getTaxDetails/{empId}")
	@ResponseBody
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<EmployeeDTO> getTaxDetails(@PathVariable ("empId") String empId) throws ParseException {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		if(empId!=null) {
			EmployeeTable emp = employeeTaxCal.getByEmpId(empId);
		
		employeeDTO.setEmployeeID(emp.getEmployeeID());
		employeeDTO.setFirstName(emp.getFirstName());
		employeeDTO.setLastName(emp.getLastName());
		
		float salary = emp.getSalary();
		
		
		Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(emp.getDateOfJoining());
		
		int getYear = getYears(date1);
			
		 String yearApril = "01/04"+"/"+String.valueOf(getYear);
		 Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(yearApril);
		
			if (getYear == getYears(date2) && date2.compareTo(date1)<0) {
				int daysLateJoined = daysBetween(date1, date2);
				if (daysLateJoined > 0) {
					float salaryInDay = salary / 30;
					int dayToBeDeducted = 365 - daysLateJoined;
					salary = salaryInDay * dayToBeDeducted;
					employeeDTO.setYearlySalary((int) salary);
				}
			}else {
			salary = salary *12;
			employeeDTO.setYearlySalary((int) salary);
			}
		if(salary <= 250000) {
			employeeDTO.setTaxAmount(0);
		}else {
		int taxPaid = employeeTaxCal.taxToBePaid(salary);
		employeeDTO.setTaxAmount(taxPaid);
		}
		
		if (employeeDTO.getYearlySalary() > 2500000) {
			int cess = ((employeeDTO.getYearlySalary() - 2500000) * 2 / 100);
			employeeDTO.setCessAmount(cess);
		}
		
		return new ResponseEntity<>(employeeDTO,HttpStatus.OK);
		}
		return new ResponseEntity<>(employeeDTO,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	private int daysBetween(Date d1, Date d2) {
		int difference = 0;

		if (d1 != null && d2 != null) {
			Calendar earlier = Calendar.getInstance();
			Calendar later = Calendar.getInstance();

			if (d1.compareTo(d2) < 0) {
				earlier.setTime(nullifyTime(d1));
				later.setTime(nullifyTime(d2));
			} else {
				earlier.setTime(nullifyTime(d2));
				later.setTime(nullifyTime(d1));
			}

			while (earlier.before(later)) {
				earlier.add(Calendar.DAY_OF_MONTH, 1);
				difference++;
			}
		}
		return difference;
	}
	
	private Date nullifyTime(Date a) {
		Calendar c = Calendar.getInstance();
		c.setTime(a);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);

		return c.getTime();
	}
	
	private int getYears(Date date) {
		Calendar calender = Calendar.getInstance();
		calender.setTime(date);
		return calender.get(Calendar.YEAR);
	}
	
}
