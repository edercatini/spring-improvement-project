package com.edercatini.springreview.web.dao;

import java.util.List;

import com.edercatini.springreview.web.domain.Employee;

public interface EmployeeDao {

	void save(Employee entity);

	void update(Employee entity);

	void delete(Long id);

	Employee findById(Long id);

	List<Employee> findAll();
}