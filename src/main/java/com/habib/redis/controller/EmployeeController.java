package com.habib.redis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.habib.redis.model.Employee;
import com.habib.redis.repository.EmployeeRepository;
import com.habib.redis.service.EmployeeService;



@RestController
@RequestMapping("/redis/v1")
public class EmployeeController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	private EmployeeService service;

	public EmployeeController(EmployeeService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public Employee addEmployee(@RequestBody Employee employee) {
		return service.addEmployee(employee);
	}
	
	
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
	public Employee findEmployee(@PathVariable String id) {
		 return service.getEmployee(id);
	}
	
	
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
	public int deleteEmployee(@PathVariable String id) {
		 return service.removeEmployee(id);
	}
	
	

}
