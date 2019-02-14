package com.edercatini.springreview.web.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Table(name = "ADDRESS")
@Getter
@Setter
public class Address extends AbstractEntity<Long> {

	@Column(nullable = false)
	private String publicPlace;

	@Column(nullable = false)
	private String neighboorhood;

	@Column(nullable = false)
	private String city;

	@Column(nullable = false, length = 2)
	@Enumerated(EnumType.STRING)
	private FederativeUnit federativeUnit;

	@Column(nullable = false, length = 9)
	private String postalCode;

	@Column(nullable = false)
	private Integer number;

	@Column(nullable = true, length = 30)
	private String complement;
}