package com.edercatini.springreview.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edercatini.springreview.web.domain.Department;
import com.edercatini.springreview.web.domain.Role;
import com.edercatini.springreview.web.service.DepartmentService;
import com.edercatini.springreview.web.service.RoleService;

@Controller
@RequestMapping("/roles")
public class RoleController {

	private RoleService roleService;

	private DepartmentService departmentService;

	@Autowired
	public RoleController(RoleService roleService, DepartmentService departmentService) {
		this.roleService = roleService;
		this.departmentService = departmentService;
	}

	@GetMapping("/register")
	public String register(Role role, ModelMap model) {
		model.addAttribute("selected", null);
		return "/roles/register";
	}

	@GetMapping("/list")
	public String list(ModelMap model) {
		model.addAttribute("roles", this.roleService.findAll());
		return "/roles/list";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap model) {
		Role role = this.roleService.findById(id);
		model.addAttribute("role", role);
		return "/roles/register";
	}

	@GetMapping("remove/{id}")
	public String remove(@PathVariable("id") Long id, ModelMap model) {
		if (this.roleService.hasAssociatedEmployees(id)) {
			model.addAttribute("fail", "Cargo não removido pois há funcionário(s) associado(s).");
		} else {
			this.roleService.delete(id);
			model.addAttribute("success", "Cargo removido com sucesso.");
		}

		return this.list(model);
	}

	@PostMapping("/save")
	public String save(@Valid Role role, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return "/roles/register";
		}

		this.roleService.save(role);
		redirectAttributes.addFlashAttribute("success", "Cargo inserido com sucesso.");
		return "redirect:/roles/register";
	}

	@PostMapping("/edit")
	public String edit(@Valid Role role, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return "/roles/register";
		}
		
		this.roleService.edit(role);
		redirectAttributes.addFlashAttribute("success", "Cargo alterado com sucesso.");
		return "redirect:/roles/register";
	}

	@ModelAttribute("departments")
	public List<Department> getDepartments() {
		return this.departmentService.findAll();
	}
}