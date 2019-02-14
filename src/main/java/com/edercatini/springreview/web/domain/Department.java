package com.edercatini.springreview.web.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Table(name = "DEPARTMENT")
@Getter
@Setter
public class Department extends AbstractEntity<Long> {

	@Column(nullable = false, unique = true, length = 60)
	private String name;

	@OneToMany(mappedBy = "department")
	private List<Role> roles;
}