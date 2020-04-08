package com.dlerroan.course.boot.service;

import java.time.LocalDate;
import java.util.ArrayList;
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

	@Override
	public List<Employee> findByName(String name) {
		return dao.findByName(name);
	}

	@Override
	public List<Employee> findByRole(Long id) {
		return dao.findByRoleId(id);
	}

	@Override
	public List<Employee> findByDate(LocalDate in, LocalDate out) {
		if(in != null && out != null) {
			return dao.findByDateInAndOut(in, out);
		}else if(in != null) {
			return dao.findByDateIn(in);
		}else if (out != null) {
			return dao.findByDateOut(out);
		}else {
			return new ArrayList<>();
		}
	}
}
