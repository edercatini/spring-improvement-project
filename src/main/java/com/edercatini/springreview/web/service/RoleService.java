package com.edercatini.springreview.web.service;

import java.util.List;

import com.edercatini.springreview.web.domain.Role;

public interface RoleService {

	void save(Role cargo);

	void edit(Role cargo);

	void delete(Long id);

	Role findById(Long id);

	List<Role> findAll();
}