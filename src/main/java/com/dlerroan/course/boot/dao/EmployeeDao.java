package com.dlerroan.course.boot.dao;

import java.util.List;

import com.dlerroan.course.boot.domain.Employee;

public interface EmployeeDao {

	void save(Employee employee);
	
	void update(Employee employee);
	
	void delete (Long id);
	
	Employee findById(Long id);
	
	List<Employee> findAll();

	List<Employee> findByName(String name);

	List<Employee> findByRoleId(Long id);
}
