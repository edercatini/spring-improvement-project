package com.edercatini.springreview.web.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Table(name = "ROLE")
@Getter
@Setter
public class Role extends AbstractEntity<Long> {

	@NotBlank(message = "Nome do cargo deve ser informado.")
	@Size(min = 4, max = 60, message = "Nome do cargo deve conter entre {min} e {max} caracteres.")
	@Column(nullable = false, unique = true, length = 60)
	private String name;

	@NotNull(message = "Departamento deve ser informado.")
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_department_fk")
	private Department department;

	@OneToMany(mappedBy = "role")
	private List<Employee> employees;
}