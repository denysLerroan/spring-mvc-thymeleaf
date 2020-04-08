package com.dlerroan.course.boot.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dlerroan.course.boot.domain.Employee;

@Repository
public class EmployeeDaoImpl extends AbstractDao<Employee, Long> implements EmployeeDao {
	
	public List<Employee> findByName(String name){
		return createQuery("select f from Employee f where f.name like concat('%', ?1, '%')", name);
	}

	@Override
	public List<Employee> findByRoleId(Long id) {
		return createQuery("select f from Employee f where f.role.id = ?1", id);
	}
	
	

}
