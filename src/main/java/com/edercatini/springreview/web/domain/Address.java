package com.edercatini.springreview.web.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Table(name = "ADDRESS")
@Getter
@Setter
public class Address extends AbstractEntity<Long> {

	@NotBlank
	@Size(min = 3, max = 255)
	@Column(nullable = false)
	private String publicPlace;

	@NotBlank
	@Size(min = 3, max = 255)
	@Column(nullable = false)
	private String neighboorhood;

	@NotBlank
	@Size(min = 3, max = 255)
	@Column(nullable = false)
	private String city;

	@NotNull(message = "{NotNull.address.federativeUnit}")
	@Column(nullable = false, length = 2)
	@Enumerated(EnumType.STRING)
	private FederativeUnit federativeUnit;

	@NotBlank
	@Size(min = 9, max = 9, message = "{Size.address.postalCode}")
	@Column(nullable = false, length = 9)
	private String postalCode;

	@NotNull(message = "{NotNull.address.number}")
	@Digits(integer = 5, fraction = 0)
	@Column(nullable = false)
	private Integer number;

	@Size(max = 255)
	@Column(nullable = true, length = 30)
	private String complement;
}