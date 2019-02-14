package com.edercatini.springreview.web.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Table(name = "EMPLOYEE")
@Getter
@Setter
public class Employee extends AbstractEntity<Long> {

	@Column(nullable = false, length = 60)
	private String name;

	@Column(nullable = false, columnDefinition = "DECIMAL(7, 2) DEFAULT 0.00")
	private BigDecimal salary;

	@Column(name = "start_date", nullable = false, columnDefinition = "DATE")
	private LocalDate startDate;

	@Column(name = "end_date", nullable = false, columnDefinition = "DATE")
	private LocalDate endDate;

	@ManyToOne
	@JoinColumn(name = "role_id_fk")
	private Role role;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id_fk")
	private Address address;
}