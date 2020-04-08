package com.dlerroan.course.boot.dao;

import java.time.LocalDate;
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

	@Override
	public List<Employee> findByDateInAndOut(LocalDate in, LocalDate out) {
		String jpql = new StringBuilder("select f from Employee f ")
				.append("where f.entryDate >= ?1 and f.departureDate <= ?2 ")
				.append("order by f.entryDate asc")
				.toString();
		return createQuery(jpql, in, out);
	}

	@Override
	public List<Employee> findByDateIn(LocalDate in) {
		String jpql = new StringBuilder("select f from Employee f ")
				.append("where f.entryDate >= ?1 ")
				.append("order by f.entryDate asc")
				.toString();
		return createQuery(jpql, in);
	}

	@Override
	public List<Employee> findByDateOut(LocalDate out) {
		String jpql = new StringBuilder("select f from Employee f ")
				.append("where f.departureDate <= ?1 ")
				.append("order by f.entryDate asc")
				.toString();
		return createQuery(jpql, out);
	}
	
	

}
