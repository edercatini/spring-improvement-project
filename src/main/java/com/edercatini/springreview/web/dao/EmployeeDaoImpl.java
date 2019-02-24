package com.edercatini.springreview.web.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.edercatini.springreview.web.domain.Employee;
import com.edercatini.springreview.web.domain.Role;

@Repository
public class EmployeeDaoImpl extends AbstractDao<Employee, Long> implements EmployeeDao {

	@Override
	public List<Employee> findByName(String name) {
		return createQuery("SELECT f FROM Employee f WHERE f.name LIKE CONCAT('%', ?1, '%')", name);
	}

	@Override
	public List<Employee> findByRole(Role role) {
		return createQuery("SELECT f FROM Employee f WHERE f.role = ?1", role);
	}

	@Override
	public List<Employee> findByStartDateEndDate(LocalDate startDate, LocalDate endDate) {
		return createQuery("SELECT f FROM Employee f WHERE f.startDate >= ?1 AND f.endDate <= ?2", startDate, endDate);
	}

	@Override
	public List<Employee> findByStartDate(LocalDate startDate) {
		return createQuery("SELECT f FROM Employee f WHERE f.startDate = ?1", startDate);
	}

	@Override
	public List<Employee> findByEndDate(LocalDate endDate) {
		return createQuery("SELECT f FROM Employee f WHERE f.endDate = ?1", endDate);
	}
}