package com.edercatini.springreview.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edercatini.springreview.web.dao.DepartmentDao;
import com.edercatini.springreview.web.domain.Department;

@Service
@Transactional(readOnly = false)
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentDao dao;

	@Autowired
	public DepartmentServiceImpl(DepartmentDao dao) {
		this.dao = dao;
	}

	@Override
	public void save(Department department) {
		this.dao.save(department);
	}

	@Override
	public void edit(Department department) {
		this.dao.update(department);
	}

	@Override
	public void delete(Long id) {
		this.dao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Department findById(Long id) {
		return this.dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Department> findAll() {
		return this.dao.findAll();
	}

	@Override
	public Boolean hasAssociatedRoles(Long id) {
		if (dao.findById(id).getRoles().isEmpty()) {
			return false;
		}

		return true;
	}
}