package com.dlerroan.course.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dlerroan.course.boot.dao.DepartmentDao;
import com.dlerroan.course.boot.domain.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentDao dao;
	
	@Transactional(readOnly = false)
	@Override
	public void save(Department department) {
		dao.save(department);
	}

	@Transactional(readOnly = false)
	@Override
	public void update(Department department) {
		dao.update(department);
	}

	@Transactional(readOnly = false)
	@Override
	public void delete(Long id) {
		dao.delete(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Department findById(Long id) {
		return dao.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Department> findAll() {
		return dao.findAll();
	}

	@Override
	public boolean departmentHasRole(Long id) {
		if(findById(id).getRoles().isEmpty()) {
			return false;
		}
		return true;
	}
}
