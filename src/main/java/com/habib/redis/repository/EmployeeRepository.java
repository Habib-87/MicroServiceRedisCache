package com.habib.redis.repository;

import java.util.Map;
import java.util.Optional;

import com.habib.redis.model.Employee;

public interface EmployeeRepository {
	
	void save(Employee emp);
    Map<String,Employee> findAll();
    Optional<Employee> findById(String id);
    void update(Employee user);
    Long delete(String id);

}
