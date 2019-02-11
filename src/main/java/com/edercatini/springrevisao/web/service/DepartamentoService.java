package com.edercatini.springrevisao.web.service;

import java.util.List;

import com.edercatini.springrevisao.web.domain.Departamento;

public interface DepartamentoService {

	void save(Departamento departamento);

	void edit(Departamento departamento);

	void delete(Long id);

	Departamento findById(Long id);

	List<Departamento> findAll();
}