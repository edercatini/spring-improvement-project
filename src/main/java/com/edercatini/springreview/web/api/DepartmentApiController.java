package com.edercatini.springreview.web.api;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.edercatini.springreview.web.domain.Department;
import com.edercatini.springreview.web.dto.DepartmentDto;
import com.edercatini.springreview.web.service.DepartmentService;

@RestController
@RequestMapping("/api")
public class DepartmentApiController {

	private DepartmentService service;

	@Autowired
	DepartmentApiController(DepartmentService service) {
		this.service = service;
	}

	@GetMapping("/department/{id}")
	public ResponseEntity<Department> findById(@PathVariable("id") Long id) {
		Department department = this.service.findById(id);
		return ResponseEntity.ok().body(department);
	}

	@GetMapping("/department")
	public ResponseEntity<List<Department>> findAll() {
		return ResponseEntity.ok().body(this.service.findAll());
	}

	@PostMapping("/department")
	public ResponseEntity<Void> post(@RequestBody DepartmentDto entity) {
		Department department = new Department();
		department.setName(entity.getName());
		this.service.save(department);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(department.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping("/department/{id}")
	public ResponseEntity<Void> update(@PathVariable("id") Long id, @RequestBody DepartmentDto entity) {
		Department department = this.service.findById(id);
		department.setName(entity.getName());
		this.service.edit(department);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/department/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		this.service.findById(id);
		this.service.delete(id);
		return ResponseEntity.noContent().build();
	}
}