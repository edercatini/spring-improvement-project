package com.edercatini.springrevisao.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edercatini.springrevisao.web.dao.CargoDao;
import com.edercatini.springrevisao.web.domain.Cargo;

@Service
@Transactional(readOnly = false)
public class CargoServiceImpl implements CargoService {

	private CargoDao dao;

	@Autowired
	public CargoServiceImpl(CargoDao dao) {
		this.dao = dao;
	}

	@Override
	public void save(Cargo cargo) {
		this.dao.save(cargo);
	}

	@Override
	public void edit(Cargo cargo) {
		this.dao.update(cargo);
	}

	@Override
	public void delete(Long id) {
		this.dao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Cargo findById(Long id) {
		return this.dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cargo> findAll() {
		return this.dao.findAll();
	}
}