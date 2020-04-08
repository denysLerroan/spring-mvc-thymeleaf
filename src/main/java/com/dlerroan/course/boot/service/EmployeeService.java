package com.dlerroan.course.boot.service;

import java.time.LocalDate;
import java.util.List;

import com.dlerroan.course.boot.domain.Employee;

public interface EmployeeService {

	void save (Employee employee);
	
	void update(Employee employee);
	
	void delete(Long id);
	
	Employee findById(Long id);
	
	List<Employee> findAll();

	List<Employee> findByName(String name);

	List<Employee> findByRole(Long id);

	List<Employee> findByDate(LocalDate in, LocalDate out);
}
