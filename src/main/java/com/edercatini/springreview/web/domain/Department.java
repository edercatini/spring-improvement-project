package com.edercatini.springreview.web.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Table(name = "DEPARTMENT")
@Getter
@Setter
public class Department extends AbstractEntity<Long> {

	@NotBlank(message = "Nome do Departamento deve ser informado.")
	@Size(min = 4, max = 60, message = "Nome do Departamento deve conter entre {min} e {max} caracteres")
	@Column(nullable = false, unique = true, length = 60)
	private String name;

	@OneToMany(mappedBy = "department")
	private List<Role> roles;
}