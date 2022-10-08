package com.employee.service;

import java.util.List;

import com.employee.model.Employee;

public interface EmployeeService {

	Employee addEmployee(Employee data);

	List<Employee> getAllEmployees();



}
