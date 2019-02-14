package com.edercatini.springreview.web.dao;

import org.springframework.stereotype.Repository;

import com.edercatini.springreview.web.domain.Employee;

@Repository
public class EmployeeDaoImpl extends AbstractDao<Employee, Long> implements EmployeeDao {
}