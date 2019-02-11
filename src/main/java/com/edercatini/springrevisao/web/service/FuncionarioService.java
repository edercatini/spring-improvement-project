package com.edercatini.springrevisao.web.service;

import java.util.List;

import com.edercatini.springrevisao.web.domain.Funcionario;

public interface FuncionarioService {

	void save(Funcionario funcionario);

	void edit(Funcionario funcionario);

	void delete(Long id);

	Funcionario findById(Long id);

	List<Funcionario> findAll();
}