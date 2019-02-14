package com.edercatini.springreview.web.service;

import java.util.List;

import com.edercatini.springreview.web.domain.Employee;

public interface EmployeeService {

	void save(Employee funcionario);

	void edit(Employee funcionario);

	void delete(Long id);

	Employee findById(Long id);

	List<Employee> findAll();
}