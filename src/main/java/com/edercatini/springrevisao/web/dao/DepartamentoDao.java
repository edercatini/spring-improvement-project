package com.edercatini.springrevisao.web.dao;

import java.util.List;

import com.edercatini.springrevisao.web.domain.Departamento;

public interface DepartamentoDao {

	void save(Departamento entity);

	void update(Departamento entity);

	void delete(Long id);

	Departamento findById(Long id);

	List<Departamento> findAll();
}