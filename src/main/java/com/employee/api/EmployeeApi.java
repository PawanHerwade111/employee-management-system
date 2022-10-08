package com.employee.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;

@RestController 
@RequestMapping("/api/employee")
public class EmployeeApi {

	@Autowired
	private EmployeeService empService;
	
	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee data) {
		Employee empData = empService.addEmployee(data);
		return empData;
		
	}
	
	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees(){
		List<Employee> empList= empService.getAllEmployees();
        return empList;  	
	}
}
