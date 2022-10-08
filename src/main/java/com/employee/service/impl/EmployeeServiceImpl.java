package com.employee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository repository;

	@Override
	public Employee addEmployee(Employee data) {
		Employee emp = repository.save(data);
		return emp;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employeeList =	repository.findAll();
	    return employeeList;
	}

}
