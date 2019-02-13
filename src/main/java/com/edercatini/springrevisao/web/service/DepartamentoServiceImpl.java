package com.edercatini.springrevisao.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edercatini.springrevisao.web.dao.DepartamentoDao;
import com.edercatini.springrevisao.web.domain.Departamento;

@Service
@Transactional(readOnly = false)
public class DepartamentoServiceImpl implements DepartamentoService {

	private DepartamentoDao dao;

	@Autowired
	public DepartamentoServiceImpl(DepartamentoDao dao) {
		this.dao = dao;
	}

	@Override
	public void salvar(Departamento departamento) {
		this.dao.save(departamento);
	}

	@Override
	public void editar(Departamento departamento) {
		this.dao.update(departamento);
	}

	@Override
	public void deletar(Long id) {
		this.dao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Departamento encontrarPorId(Long id) {
		return this.dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Departamento> encontrarTodos() {
		return this.dao.findAll();
	}
}