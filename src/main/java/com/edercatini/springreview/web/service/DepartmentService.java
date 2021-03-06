package com.edercatini.springreview.web.service;

import java.util.List;

import com.edercatini.springreview.web.domain.Department;

public interface DepartmentService {

	void save(Department department);

	void edit(Department department);

	void delete(Long id);

	Department findById(Long id);

	List<Department> findAll();

	Boolean hasAssociatedRoles(Long id);
}