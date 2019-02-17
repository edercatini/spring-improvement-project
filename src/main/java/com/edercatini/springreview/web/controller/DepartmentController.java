package com.edercatini.springreview.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edercatini.springreview.web.domain.Department;
import com.edercatini.springreview.web.service.DepartmentService;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

	private DepartmentService service;

	@Autowired
	DepartmentController(DepartmentService service) {
		this.service = service;
	}

	@GetMapping("/register")
	public String register(Department departamento) {
		return "/department/register";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("department", service.findById(id));
		return "/department/register";
	}

	@GetMapping("/list")
	public String list(ModelMap model) {
		model.addAttribute("departments", service.findAll());
		return "/department/list";
	}

	@PostMapping("/save")
	public String save(Department department) {
		this.service.save(department);
		return "redirect:/departments/register";
	}

	@PostMapping("/edit")
	public String edit(Department department) {
		this.service.edit(department);
		return "redirect:/departments/register";
	}
}