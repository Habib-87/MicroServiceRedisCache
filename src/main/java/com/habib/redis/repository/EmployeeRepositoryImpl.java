package com.habib.redis.repository;

import java.util.Map;
import java.util.Optional;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.habib.redis.model.Employee;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
	
	private RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String, String, Employee> hashOperations; 
    
    

	public EmployeeRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
		this.hashOperations = this.redisTemplate.opsForHash();
	}

	@Override
	public void save(Employee emp) {
		hashOperations.put("EMPLOYEE", emp.getId(), emp);

	}

	@Override
	public Map<String, Employee> findAll() {
		return hashOperations.entries("EMPLOYEE");
	}

	@Override
	public Optional<Employee> findById(String id) {
		Employee emp = (Employee)hashOperations.get("EMPLOYEE",id);
		Optional<Employee> opEmp = Optional.ofNullable(emp);
		 return opEmp;
	}

	@Override
	public void update(Employee emp) {
		save(emp);
	}

	@Override
	public Long delete(String id) {
		return hashOperations.delete("EMPLOYEE",id);

	}

}
