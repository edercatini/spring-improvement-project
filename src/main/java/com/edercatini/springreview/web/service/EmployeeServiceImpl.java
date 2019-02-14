package com.edercatini.springreview.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edercatini.springreview.web.dao.EmployeeDao;
import com.edercatini.springreview.web.domain.Employee;

@Service
@Transactional(readOnly = false)
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao dao;

	@Autowired
	EmployeeServiceImpl(EmployeeDao dao) {
		this.dao = dao;
	}

	@Override
	public void save(Employee funcionario) {
		this.dao.save(funcionario);
	}

	@Override
	public void edit(Employee funcionario) {
		this.dao.update(funcionario);
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
}