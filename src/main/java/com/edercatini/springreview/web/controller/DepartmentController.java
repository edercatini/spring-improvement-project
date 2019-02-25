package com.edercatini.springreview.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String preEdit(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("department", service.findById(id));
		return "/department/register";
	}

	@GetMapping("/list")
	public String list(ModelMap model) {
		model.addAttribute("departments", service.findAll());
		return "/department/list";
	}

	@GetMapping("/remove/{id}")
	public String remove(@PathVariable("id") Long id, ModelMap model) {
		if (service.hasAssociatedRoles(id)) {
			model.addAttribute("fail", "Departamento não removido pois há cargo(s) associado(s).");
		} else {
			this.service.delete(id);
			model.addAttribute("success", "Departamento excluído com sucesso.");
		}

		return this.list(model);
	}

	@PostMapping("/save")
	public String save(@Valid Department department, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return "/department/register";
		}

		this.service.save(department);
		redirectAttributes.addFlashAttribute("success", "Departamento inserido com sucesso.");
		return "redirect:/departments/register";
	}

	@PostMapping("/edit")
	public String edit(Department department, RedirectAttributes redirectAttributes) {
		this.service.edit(department);
		redirectAttributes.addFlashAttribute("success", "Departamento alterado com sucesso.");
		return "redirect:/departments/register";
	}
}