package com.dlerroan.course.boot.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.dlerroan.course.boot.domain.Role;
import com.dlerroan.course.boot.service.RoleService;

@Component
public class StringToRoleConverter implements Converter<String, Role>{

	@Autowired
	private RoleService service;
	
	@Override
	public Role convert(String text) {
		if(text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.findById(id);
	}
}
