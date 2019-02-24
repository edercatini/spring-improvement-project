package com.edercatini.springreview.web.dao;

import java.time.LocalDate;
import java.util.List;

import com.edercatini.springreview.web.domain.Employee;
import com.edercatini.springreview.web.domain.Role;

public interface EmployeeDao {

	void save(Employee entity);

	void update(Employee entity);

	void delete(Long id);

	Employee findById(Long id);

	List<Employee> findAll();

	List<Employee> findByName(String name);

	List<Employee> findByRole(Role role);

	List<Employee> findByStartDateEndDate(LocalDate startDate, LocalDate endDate);

	List<Employee> findByStartDate(LocalDate startDate);

	List<Employee> findByEndDate(LocalDate endDate);
}