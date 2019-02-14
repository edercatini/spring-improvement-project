package com.edercatini.springreview.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cargos")
public class RoleController {

	@GetMapping("/cadastrar")
	public String index() {
		return "/cargo/cadastro";
	}

	@GetMapping("/listar")
	public String list() {
		return "/cargo/lista";
	}
}