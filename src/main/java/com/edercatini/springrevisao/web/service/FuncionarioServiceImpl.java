package com.edercatini.springrevisao.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edercatini.springrevisao.web.dao.FuncionarioDao;
import com.edercatini.springrevisao.web.domain.Funcionario;

@Service
@Transactional(readOnly = false)
public class FuncionarioServiceImpl implements FuncionarioService {

	private FuncionarioDao dao;

	@Autowired
	FuncionarioServiceImpl(FuncionarioDao dao) {
		this.dao = dao;
	}

	@Override
	public void save(Funcionario funcionario) {
		this.dao.save(funcionario);
	}

	@Override
	public void edit(Funcionario funcionario) {
		this.dao.update(funcionario);
	}

	@Override
	public void delete(Long id) {
		this.dao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Funcionario findById(Long id) {
		return this.dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Funcionario> findAll() {
		return this.dao.findAll();
	}
}