package com.sg.empportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sg.empportal.entity.Employee;
import com.sg.empportal.helper.ResponseHelper;
import com.sg.empportal.io.RestApiHeader;
import com.sg.empportal.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeePortalController {
	
	@Autowired
	private ResponseHelper helper;
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping(path="/save")
	public RestApiHeader<Employee> saveNewEmployee(@RequestBody Employee newEmployeeEntry){
		
		Employee employee = service.saveNewEmployee(newEmployeeEntry);
		
		RestApiHeader<Employee> response = helper.getSuccessResponse(employee);
		return response;
	}
	
	@GetMapping(path = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
	public RestApiHeader<List<Employee>> getAllEmployees(){
		
		List<Employee> employeeList = service.getAllEmployees();
		
		RestApiHeader<List<Employee>> response = helper.getSuccessResponse(employeeList);
		return response;
	}
}
