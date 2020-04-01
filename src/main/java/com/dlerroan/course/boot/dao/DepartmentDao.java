package com.dlerroan.course.boot.dao;

import java.util.List;

import com.dlerroan.course.boot.domain.Department;

public interface DepartmentDao {
	
	void save(Department department);
	
	void update(Department department);
	
	void delete (Long id);
	
	Department findById(Long id);
	
	List<Department> findAll();
}
