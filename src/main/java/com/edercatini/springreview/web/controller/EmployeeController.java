package com.edercatini.springreview.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/funcionarios")
public class EmployeeController {

	@GetMapping("/cadastrar")
	public String index() {
		return "/funcionario/cadastro";
	}

	@GetMapping("/listar")
	public String list() {
		return "/funcionario/lista";
	}
}