package com.edercatini.springrevisao.web.dao;

import java.util.List;

import com.edercatini.springrevisao.web.domain.Funcionario;

public interface FuncionarioDao {

	void save(Funcionario entity);

	void update(Funcionario entity);

	void delete(Long id);

	Funcionario findById(Long id);

	List<Funcionario> findAll();
}