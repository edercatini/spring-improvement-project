package com.edercatini.springreview.web.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class DepartmentDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
}