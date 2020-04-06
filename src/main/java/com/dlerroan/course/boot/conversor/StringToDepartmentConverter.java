package com.dlerroan.course.boot.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.dlerroan.course.boot.domain.Department;
import com.dlerroan.course.boot.service.DepartmentService;

@Component
public class StringToDepartmentConverter implements Converter<String, Department>{

	@Autowired
	private DepartmentService service;
	
	@Override
	public Department convert(String text) {
		if(text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.findById(id);
	}
}
