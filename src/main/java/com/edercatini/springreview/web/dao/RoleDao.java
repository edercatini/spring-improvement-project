package com.edercatini.springreview.web.dao;

import java.util.List;

import com.edercatini.springreview.web.domain.Role;

public interface RoleDao {

	void save(Role entity);

	void update(Role entity);

	void delete(Long id);

	Role findById(Long id);

	List<Role> findAll();
}