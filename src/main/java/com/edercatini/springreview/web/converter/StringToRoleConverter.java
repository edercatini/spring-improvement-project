 package com.edercatini.springreview.web.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.edercatini.springreview.web.domain.Role;
import com.edercatini.springreview.web.service.RoleService;

@Component
public class StringToRoleConverter implements Converter<String, Role> {

	private RoleService service;

	public StringToRoleConverter(RoleService service) {
		this.service = service;
	}

	@Override
	public Role convert(String arg) {
		if (arg.isEmpty()) {
			return null;
		}

		Long id = Long.valueOf(arg);

		return service.findById(id);
	}

}