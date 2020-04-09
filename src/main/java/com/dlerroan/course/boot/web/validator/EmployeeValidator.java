package com.dlerroan.course.boot.web.validator;

import java.time.LocalDate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.dlerroan.course.boot.domain.Employee;

public class EmployeeValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Employee.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		Employee e = (Employee) object;
		
		LocalDate in = e.getEntryDate();
		
		if(e.getDepartureDate() != null) {
			if(e.getDepartureDate().isBefore(in)) {
				errors.rejectValue("departureDate", "PosteriorEntryDate.employee.departureDate");
			}
		}
		
	}

}
