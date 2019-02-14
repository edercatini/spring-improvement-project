package com.edercatini.springreview.web.dao;

import org.springframework.stereotype.Repository;

import com.edercatini.springreview.web.domain.Department;

@Repository
public class DepartmentDaoImpl extends AbstractDao<Department, Long> implements DepartmentDao {
}