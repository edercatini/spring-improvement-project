package com.edercatini.springrevisao.web.service;

import java.util.List;

import com.edercatini.springrevisao.web.domain.Cargo;

public interface CargoService {

	void save(Cargo cargo);

	void edit(Cargo cargo);

	void delete(Long id);

	Cargo findById(Long id);

	List<Cargo> findAll();
}