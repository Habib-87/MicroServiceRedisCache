package com.habib.redis.service;

import java.util.Optional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.habib.redis.model.Employee;
import com.habib.redis.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	private EmployeeRepository repo;

	public EmployeeService(EmployeeRepository repo) {
		this.repo = repo;
	}
	
	@Cacheable(key = "#id", value = "employees")
	public Employee getEmployee(String id) {
		Optional<Employee> emp = repo.findById(id);
		return emp.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Employee not found"));
	}
	
	@CacheEvict(key = "#id", value = "employees")
	public int removeEmployee(String id) {
		var res = repo.delete(id);
		return res.intValue();
	}
	
	public Employee addEmployee(Employee employee) {
		 repo.save(employee);
		 Employee savedEmp = getEmployee(employee.getId());
		 return savedEmp;
	}
	

}
