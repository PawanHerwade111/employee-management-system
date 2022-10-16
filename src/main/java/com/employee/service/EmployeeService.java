package com.employee.service;

import java.util.List;

import com.employee.exception.EmployeeNotFoundException;
import com.employee.model.Employee;

public interface EmployeeService {

	Employee addEmployee(Employee data) throws EmployeeNotFoundException;

	List<Employee> getAllEmployees();

	Employee getEmployee(Long id) throws EmployeeNotFoundException;

	Employee updateEmployee(Long id, Employee data) throws EmployeeNotFoundException;

	String deleteEmployee(Long id);



}
