package com.edercatini.springreview.web.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edercatini.springreview.web.domain.Employee;
import com.edercatini.springreview.web.domain.FederativeUnit;
import com.edercatini.springreview.web.domain.Role;
import com.edercatini.springreview.web.service.EmployeeService;
import com.edercatini.springreview.web.service.RoleService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private RoleService roleService;

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(RoleService roleService, EmployeeService employeeService) {
		this.roleService = roleService;
		this.employeeService = employeeService;
	}

	@GetMapping("/register")
	public String index(Employee employee, ModelMap model) {
		return "/employee/register";
	}

	@GetMapping("/list")
	public String list(ModelMap model) {
		model.addAttribute("employees", this.employeeService.findAll());
		return "/employee/list";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap model) {
		Employee employee = employeeService.findById(id);
		model.addAttribute("employee", employee);
		return "employee/register";
	}
	
	@GetMapping("/remove/{id}")
	public String remove(@PathVariable("id") Long id, ModelMap model) {
		this.employeeService.delete(id);
		model.addAttribute("success", "Funcionário removido com sucesso.");
		return this.list(model);
	}
	
	@GetMapping("/search/name")
	public String findByName(@RequestParam("name") String name, ModelMap model) {
		List<Employee> employees = this.employeeService.findByName(name);
		model.addAttribute("employees", employees);
		return "/employee/list";
	}
	
	@GetMapping("/search/role")
	public String findByRole(@RequestParam("role") Role role, ModelMap model) {
		List<Employee> employees = this.employeeService.findByRole(role);
		model.addAttribute("employees", employees);
		return "/employee/list";
	}
	
	@GetMapping("/search/date")
	public String findByDate(@RequestParam("startDate") @DateTimeFormat(iso = ISO.DATE) LocalDate startDate, @RequestParam("endDate") @DateTimeFormat(iso = ISO.DATE) LocalDate endDate, ModelMap model) {
		List<Employee> employees = this.employeeService.findByDate(startDate, endDate);
		model.addAttribute("employees", employees);
		return "/employee/list";
	}

	@PostMapping("/save")
	public String save(Employee employee, RedirectAttributes redirectAttributes) {
		this.employeeService.save(employee);
		redirectAttributes.addFlashAttribute("success", "Funcionário inserido com sucesso.");
		return "redirect:/employees/register";
	}
	
	@PostMapping("/edit")
	public String edit(Employee employee, RedirectAttributes redirectAttributes) {
		this.employeeService.edit(employee);
		redirectAttributes.addFlashAttribute("success", "Funcionário alterado com sucesso.");
		return "redirect:/employees/register";
	}

	@ModelAttribute("roles")
	public List<Role> getRoles() {
		return roleService.findAll();
	}

	@ModelAttribute("federativeUnits")
	public FederativeUnit[] getFederativeUnits() {
		return FederativeUnit.values();
	}
}