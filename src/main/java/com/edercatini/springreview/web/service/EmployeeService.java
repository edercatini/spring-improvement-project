package com.edercatini.springreview.web.service;

import java.util.List;

import com.edercatini.springreview.web.domain.Employee;

public interface EmployeeService {

	void save(Employee employee);

	void edit(Employee employee);

	void delete(Long id);

	Employee findById(Long id);

	List<Employee> findAll();
}