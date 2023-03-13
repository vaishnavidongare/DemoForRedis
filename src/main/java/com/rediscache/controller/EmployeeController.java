package com.rediscache.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rediscache.entity.Employee;
import com.rediscache.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
   
	private final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	public EmployeeService empservice;
	
	@GetMapping("/employee/{id}")
	 @Cacheable(value = "employee",key = "#id")
	public Employee getEmployee(@PathVariable("id") int id) {
		 logger.debug(" >> EmployeeController : /employee/{} call : ",id);
		return empservice.getEmployee(id);
		
	}
	@PostMapping("/employee")
	public Employee saveEmployee(@RequestBody Employee emp) {
		logger.debug(" >> EmployeeController : /employee : ",emp.toString());
		return empservice.saveEmployee(emp);
	}
	
	
}
