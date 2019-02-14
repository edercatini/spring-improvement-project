package com.edercatini.springreview.web.dao;

import org.springframework.stereotype.Repository;

import com.edercatini.springreview.web.domain.Role;

@Repository
public class RoleDaoImpl extends AbstractDao<Role, Long> implements RoleDao {
}