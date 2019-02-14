package com.edercatini.springreview.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edercatini.springreview.web.domain.Department;
import com.edercatini.springreview.web.service.DepartmentService;

@Controller
@RequestMapping("/departamentos")
public class DepartmentController {

	private DepartmentService service;

	@Autowired
	DepartmentController(DepartmentService service) {
		this.service = service;
	}

	@GetMapping("/cadastrar")
	public String index(Department departamento) {
		return "/departamento/cadastro";
	}

	@GetMapping("/listar")
	public String list(ModelMap model) {
		model.addAttribute("departments", service.findAll());
		return "/departamento/lista";
	}

	@PostMapping("/salvar")
	public String save(Department departamento) {
		this.service.save(departamento);
		return "redirect:/departamentos/cadastrar";
	}
}