package com.dlerroan.course.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dlerroan.course.boot.dao.RoleDao;
import com.dlerroan.course.boot.domain.Role;

@Service
@Transactional(readOnly = false)
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleDao dao;
	
	@Override
	public void save(Role role) {
		dao.save(role);
	}

	@Override
	public void update(Role role) {
		dao.update(role);
	}

	@Override
	public void delete(Long id) {
		dao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Role findById(Long id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Role> findAll() {
		return dao.findAll();
	}
	
	@Override
	public boolean roleHasEmployee(Long id) {
		if(findById(id).getEmployee().isEmpty()) {
			return false;
		}
		return true;
	}
}
