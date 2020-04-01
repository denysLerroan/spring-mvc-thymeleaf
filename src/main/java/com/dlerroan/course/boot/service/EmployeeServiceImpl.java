package com.dlerroan.course.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dlerroan.course.boot.dao.EmployeeDao;
import com.dlerroan.course.boot.domain.Employee;

@Service
@Transactional(readOnly = false)
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao dao;
	
	@Override
	public void save(Employee employee) {
		dao.save(employee);
	}

	@Override
	public void update(Employee employee) {
		dao.update(employee);
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Employee findById(Long id) {
		return dao.findById(id);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Employee> findAll() {
		return dao.findAll();
	}
}
