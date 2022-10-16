package com.employee.service.impl;

import java.util.List;
import java.util.Optional;

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

	@Override
	public Employee getEmployee(Long id) {
		Optional<Employee> emp = repository.findById(id);
		return emp.get();
	}

	@Override
	public Employee updateEmployee(Long id, Employee data) {		
		Employee emp = repository.findById(id).orElseThrow();
		emp.setEmail(data.getEmail());
		emp.setEmployeeName(data.getEmployeeName());
		emp.setLocation(data.getLocation());
		emp.setMobileNo(data.getMobileNo());
		repository.save(emp);
		return emp;
	}

	@Override
	public String deleteEmployee(Long id) {
		repository.deleteById(id);
		return "Employee deleted successfully";
	}

}
