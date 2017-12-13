package com.employeeprovider.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class EmployeeProvider {

	public EmployeeProvider ()
		{
		loadEmployeeMap();
		}
	
		private Map<Integer,Employee> employeeMap;
		
		private HashMap<Integer,Employee> loadEmployeeMap()
		{
		employeeMap=new HashMap<>();
		employeeMap.put(1,new Employee(1,"praveen","plano"));
		employeeMap.put(2,new Employee(2,"richard","irving"));
		employeeMap.put(3,new Employee(3,"champak","richardson"));
		return null;
		}
		@WebMethod
		public Employee findEmployee(int id){
		//TODO - If given employee id exists in the map, then return true else return false.
			Employee employee=employeeMap.get(id);
			if(employee==null){
				return new Employee(-1,"NOT FOUND","NOT FOUND");
			}
			return employee;
		}
		@WebMethod
		public List<Employee> findByName(String name){
		//TODO - Find all employees from map, which contains the given name - ignore case.
			List<Employee> elist=new ArrayList<>();
			Employee employee;
			for(Integer e:employeeMap.keySet()){
				employee=employeeMap.get(e);
				if(employee.getName().equalsIgnoreCase(name)){
					elist.add(employee);
				}
			}
			if(elist.isEmpty()){
				elist.add(new Employee(-1,"NOT FOUND","NOT FOUND"));
				}
			return elist;
		}
		@WebMethod
		public Boolean addEmployee(Employee employee){
		//TODO - If employee does not exist in map, then add in map - return true
		//TODO - If employee exists in map or is null, return false.
			if(employeeMap.containsKey(employee.getId()) || employee==null){
				return false;
			}
			else{
				employeeMap.put(employee.getId(), employee);
			return true;
			}
		}
		@WebMethod
		public Boolean updateEmployee(int id){
		//TODO - If employee does not exist in map, or is null, return false.
		//TODO - If employee exists in map - update with new employee object - return true
			Integer idd=id;
			if(!employeeMap.containsKey(id) || idd==null){
				return false;
			}else{
				employeeMap.put(id, new Employee(id,"sanjay","Irving"));
				return true;
			}
		}
		@WebMethod
		public Boolean removeEmployee(Employee employee){
		//TODO - If employee does not exist in map, or is null, return false.
		//TODO - If employee exists in map - update with new employee object - return true
			if(!employeeMap.containsKey(employee.getId()) || employee==null){
				return false;
			}else{
				employeeMap.remove(employee.getId());
				return true;
			}
		}

		
}
