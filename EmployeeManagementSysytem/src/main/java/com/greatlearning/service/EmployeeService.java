package com.greatlearning.service;

import java.util.List;

import com.greatlearning.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployee();

	Employee getById(long id);

	void deleteViaId(long id);

	Employee updateEmployee(Employee employee);

	Employee saveEmployee(Employee employee);

}