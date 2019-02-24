package com.edercatini.springreview.web.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edercatini.springreview.web.dao.EmployeeDao;
import com.edercatini.springreview.web.domain.Employee;
import com.edercatini.springreview.web.domain.Role;

@Service
@Transactional(readOnly = false)
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao dao;

	@Autowired
	EmployeeServiceImpl(EmployeeDao dao) {
		this.dao = dao;
	}

	@Override
	public void save(Employee employee) {
		this.dao.save(employee);
	}

	@Override
	public void edit(Employee employee) {
		this.dao.update(employee);
	}

	@Override
	public void delete(Long id) {
		this.dao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Employee findById(Long id) {
		return this.dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Employee> findAll() {
		return this.dao.findAll();
	}

	@Override
	public List<Employee> findByName(String name) {
		List<Employee> employees = this.dao.findByName(name);
		return employees;
	}

	@Override
	public List<Employee> findByRole(Role role) {
		return this.dao.findByRole(role);
	}

	@Override
	public List<Employee> findByDate(LocalDate startDate, LocalDate endDate) {
		if (startDate != null && endDate != null) {	    	
            return dao.findByStartDateEndDate(startDate, endDate);
        } else if (startDate != null) {        	
	        return dao.findByStartDate(startDate);
        } else if (endDate != null) {        	
	        return dao.findByEndDate(endDate);
        } else {
        	return new ArrayList<>();
        }
	}
}