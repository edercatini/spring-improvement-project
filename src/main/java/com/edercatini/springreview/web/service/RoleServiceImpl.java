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
	public void save(Role cargo) {
		this.dao.save(cargo);
	}

	@Override
	public void edit(Role cargo) {
		this.dao.update(cargo);
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
}