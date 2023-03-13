package com.rediscache.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import com.rediscache.entity.Employee;
import com.rediscache.exception.EmployeeNotFoundException;
import com.rediscache.repository.EmployeeRepo;
@Service
public class EmployeeService {

	private final Logger logger = LoggerFactory.getLogger(EmployeeService.class);
	
	@Autowired
	public EmployeeRepo erepo;
	
	@CachePut(value="Employee", key="#id")
	public Employee getEmployee(int id) {	
		logger.debug(" >> EmployeeService : Entering getUser");
		Employee e = erepo.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee Not Found"));
		return e;
	}

	public Employee saveEmployee(Employee emp) {
		logger.debug(" >> EmployeeService : Entering create");
		Employee e=erepo.save(emp);
		logger.debug(" << UserService : Exiting create");
		return e;
	}

}
