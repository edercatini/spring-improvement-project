package com.edercatini.springreview.web.dao;

import java.util.List;

import com.edercatini.springreview.web.domain.Department;

public interface DepartmentDao {

	void save(Department entity);

	void update(Department entity);

	void delete(Long id);

	Department findById(Long id);

	List<Department> findAll();
}