package com.employee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.exception.EmployeeNotFoundException;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	@Override
	public Employee addEmployee(Employee data) throws EmployeeNotFoundException {
		Employee emp = null;

		try {
			List<Employee> employeeList = repository.findAll();
			if (employeeList != null && !employeeList.isEmpty()) {
				boolean val = employeeList.stream().filter(i -> i.getEmail().equals(data.getEmail())).findAny()
						.isPresent();
				if (val == true) {
					throw new EmployeeNotFoundException("Email id is already Present.");
				} else {
					emp = repository.save(data);
				}
			} else {
				emp = repository.save(data);
			}
		} catch (EmployeeNotFoundException e) {
			e.printStackTrace();
			throw new EmployeeNotFoundException("Email id is already Present.");
		}
		return emp;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employeeList = repository.findAll();
		return employeeList;
	}

	@Override
	public Employee getEmployee(Long id) throws EmployeeNotFoundException {
		Employee emp = repository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not available for given id."));
		return emp;
	}

	@Override
	public Employee updateEmployee(Long id, Employee data) throws EmployeeNotFoundException {
		Employee emp = repository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not available for given id."));
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
