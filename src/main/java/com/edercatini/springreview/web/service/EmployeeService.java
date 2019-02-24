package com.edercatini.springreview.web.service;

import java.time.LocalDate;
import java.util.List;

import com.edercatini.springreview.web.domain.Employee;
import com.edercatini.springreview.web.domain.Role;

public interface EmployeeService {

	void save(Employee employee);

	void edit(Employee employee);

	void delete(Long id);

	Employee findById(Long id);

	List<Employee> findAll();

	List<Employee> findByName(String name);

	List<Employee> findByRole(Role role);

	List<Employee> findByDate(LocalDate startDate, LocalDate endDate);
}