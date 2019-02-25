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
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Table(name = "EMPLOYEE")
@Getter
@Setter
public class Employee extends AbstractEntity<Long> {

	@NotBlank
	@Size(max = 255, min = 3)
	@Column(nullable = false, length = 60)
	private String name;

	@NotNull
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(nullable = false, columnDefinition = "DECIMAL(7, 2) DEFAULT 0.00")
	private BigDecimal salary;

	@NotNull
	@PastOrPresent(message = "{PastOrPresent.funcionario.dataEntrada}")
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "start_date", nullable = false, columnDefinition = "DATE")
	private LocalDate startDate;

	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "end_date", nullable = false, columnDefinition = "DATE")
	private LocalDate endDate;

	@NotNull(message = "{NotNull.employee.role}")
	@ManyToOne
	@JoinColumn(name = "role_id_fk")
	private Role role;

	@Valid
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id_fk")
	private Address address;
}