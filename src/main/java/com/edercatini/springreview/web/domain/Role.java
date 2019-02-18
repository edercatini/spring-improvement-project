package com.edercatini.springreview.web.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Table(name = "ROLE")
@Getter
@Setter
public class Role extends AbstractEntity<Long> {

	@Column(nullable = false, unique = true, length = 60)
	private String name;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_department_fk")
	private Department department;

	@OneToMany(mappedBy = "role")
	private List<Employee> employees;
}