package com.habib.redis.service;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.habib.redis.model.Employee;
import com.habib.redis.repository.EmployeeRepository;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class EmployeeServiceTest {
	
	@InjectMocks
	private EmployeeService empService;
	
	@Mock
	EmployeeRepository repoMock;
	
	 @Before
	 public void init() {
	  }
	/**
	 * JUnit test to check findEmployee method is working or not
	 */
	 
	@Test
	public void getEmployee() {
		//given
		Employee emp = new Employee("1", "Habib", Long.valueOf("2000"));
		when(repoMock.findById(eq("1"))).thenReturn(Optional.ofNullable(emp));
		
		Employee retEmp = empService.getEmployee("1");
		
		Assert.assertEquals("1", retEmp.getId());
		Assert.assertEquals("Habib", retEmp.getName());

		
	}
	
	// Write other jUnit test cases

}
