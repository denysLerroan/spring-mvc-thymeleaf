package com.dlerroan.course.boot.dao;

import org.springframework.stereotype.Repository;

import com.dlerroan.course.boot.domain.Employee;

@Repository
public class EmployeeDaoImpl extends AbstractDao<Employee, Long> implements EmployeeDao {

}
