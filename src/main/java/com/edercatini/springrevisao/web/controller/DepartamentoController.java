package com.edercatini.springrevisao.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edercatini.springrevisao.web.domain.Departamento;
import com.edercatini.springrevisao.web.service.DepartamentoService;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {

	private DepartamentoService departamentoService;

	@Autowired
	DepartamentoController(DepartamentoService departamentoService) {
		this.departamentoService = departamentoService;
	}

	@GetMapping("/cadastrar")
	public String cadastrar(Departamento departamento) {
		return "/departamento/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("departamentos", departamentoService.encontrarTodos());
		return "/departamento/lista";
	}

	@PostMapping("/salvar")
	public String salvar(Departamento departamento) {
		this.departamentoService.salvar(departamento);
		return "redirect:/departamentos/cadastrar";
	}
}