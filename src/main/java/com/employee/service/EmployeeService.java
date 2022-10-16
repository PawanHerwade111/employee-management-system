package com.employee.service;

import java.util.List;

import com.employee.model.Employee;

public interface EmployeeService {

	Employee addEmployee(Employee data);

	List<Employee> getAllEmployees();

	Employee getEmployee(Long id);

	Employee updateEmployee(Long id, Employee data);

	String deleteEmployee(Long id);



}
