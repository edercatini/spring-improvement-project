package com.edercatini.springreview.web.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.edercatini.springreview.web.domain.Department;
import com.edercatini.springreview.web.service.DepartmentService;

@Component
public class StringToDepartmentConverter implements Converter<String, Department> {

	private DepartmentService service;

	public StringToDepartmentConverter(DepartmentService service) {
		this.service = service;
	}

	@Override
	public Department convert(String arg) {
		if (arg.isEmpty()) {
			return null;
		}

		Long id = Long.valueOf(arg);

		return service.findById(id);
	}

}