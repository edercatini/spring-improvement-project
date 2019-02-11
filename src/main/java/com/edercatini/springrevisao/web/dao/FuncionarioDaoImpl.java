package com.edercatini.springrevisao.web.dao;

import org.springframework.stereotype.Repository;

import com.edercatini.springrevisao.web.domain.Funcionario;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao {
}