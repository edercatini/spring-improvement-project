package com.edercatini.springrevisao.web.service;

import java.util.List;

import com.edercatini.springrevisao.web.domain.Departamento;

public interface DepartamentoService {

	void salvar(Departamento departamento);

	void editar(Departamento departamento);

	void deletar(Long id);

	Departamento encontrarPorId(Long id);

	List<Departamento> encontrarTodos();
}