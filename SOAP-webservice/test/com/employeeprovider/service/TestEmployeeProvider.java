package com.employeeprovider.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class TestEmployeeProvider {

	@Test
	public void testFindEmployee(){
		
		EmployeeProvider ep=new EmployeeProvider();
		Employee emp=ep.findEmployee(1);
		assertEquals("praveen",emp.getName());
	}
	
	@Test
	public void testFindByName(){
		
		EmployeeProvider ep=new EmployeeProvider();
		List<Employee> emlist=ep.findByName("praveen");
		assertNotNull(emlist);
	}
	
	@Test
	public void testAddEmployee(){
		
		EmployeeProvider ep=new EmployeeProvider();
		Employee employee=new Employee();
		employee.setId(4);employee.setName("sanjay");employee.setAddress("Texas");
		assertEquals(true,ep.addEmployee(employee));
	}
	
	@Test
	public void testUpdateEmployee(){
		
		EmployeeProvider ep=new EmployeeProvider();
		
		assertEquals(true,ep.updateEmployee(3));
	}
	
	@Test
	public void testRemoveEmployee(){
		
		EmployeeProvider ep=new EmployeeProvider();
		Employee employee=new Employee();
		employee.setId(3);
		
		assertEquals(true,ep.removeEmployee(employee));
	}
	
	
}
