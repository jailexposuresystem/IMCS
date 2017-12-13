package com.employeeclient.main;

import java.util.List;

import com.employeeclient.proxy.Employee;
import com.employeeclient.proxy.EmployeeProviderService;

public class EmployeeMain {

	public static void main(String[] args) {
		EmployeeProviderService service=new EmployeeProviderService();
		
		Employee employee=service.getEmployeeProviderPort().findEmployee(2);
		System.out.println(employee.getId()+" "+employee.getName()+" "+employee.getAddress());
		
		Employee emp=new Employee();
		emp.setId(7);emp.setName("sanjay");emp.setAddress("Texas");
		Boolean add=service.getEmployeeProviderPort().addEmployee(emp);
		System.out.println(add);
		
		Boolean update=service.getEmployeeProviderPort().updateEmployee(3);
		System.out.println(update);
		
		List<Employee> emplist=service.getEmployeeProviderPort().findByName("sanjay");
		for(Employee e:emplist){System.out.println(e.getId()+" "+e.getName()+" "+e.getAddress());}
		
		emp.setId(3);
		Boolean remove=service.getEmployeeProviderPort().removeEmployee(emp);
		System.out.println(remove);
	}

}
