package com.edercatini.springreview.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edercatini.springreview.web.dao.RoleDao;
import com.edercatini.springreview.web.domain.Role;

@Service
@Transactional(readOnly = false)
public class RoleServiceImpl implements RoleService {

	private RoleDao dao;

	@Autowired
	public RoleServiceImpl(RoleDao dao) {
		this.dao = dao;
	}

	@Override
	public void save(Role role) {
		this.dao.save(role);
	}

	@Override
	public void edit(Role role) {
		this.dao.update(role);
	}

	@Override
	public void delete(Long id) {
		this.dao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Role findById(Long id) {
		return this.dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Role> findAll() {
		return this.dao.findAll();
	}

	@Override
	public Boolean hasAssociatedEmployees(Long id) {
		if (this.findById(id).getEmployees().isEmpty()) {
			return false;
		}

		return true;
	}
}