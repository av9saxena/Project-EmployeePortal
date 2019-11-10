package com.sg.empportal.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.sg.empportal.entity.Employee;
import com.sg.empportal.exception.EPortalException;
import com.sg.empportal.exception.ErrorCodesMessages;
import com.sg.empportal.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee saveNewEmployee(Employee newEntry) {

		verifyAttributes(newEntry);
		
		String employeeId = "" + (new Date()).getTime(); newEntry.setEmp_id(employeeId);
		  
		newEntry = employeeRepository.save(newEntry);
		 		
		return newEntry;
	}

	private void verifyAttributes(Employee employee) {

		boolean isOk = true;

		if (StringUtils.isEmpty(employee.getFirstname().trim()) 
				|| StringUtils.isEmpty(employee.getLastname().trim()) 
				|| StringUtils.isEmpty(employee.getGender().trim()) 
				|| employee.getDob() == null
				|| StringUtils.isEmpty(employee.getDepartment().trim())) {
			isOk = false;
		}

		if (!isOk) {
			throw new EPortalException(ErrorCodesMessages.EP_0001.toString(), ErrorCodesMessages.EP_0001.getErrorMessage());
		}
	}
	
	public List<Employee> getAllEmployees(){
		
		List<Employee> employeeList = employeeRepository.findAll(Sort.by("firstname"));
		
		return employeeList;
	}
}
