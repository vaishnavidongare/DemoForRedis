package com.rediscache.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rediscache.entity.Employee;
@Repository
public interface EmployeeRepo extends CrudRepository<Employee,Integer> {

}
