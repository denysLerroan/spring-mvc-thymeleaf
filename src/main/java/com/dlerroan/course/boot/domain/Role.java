package com.dlerroan.course.boot.domain;

import javax.persistence.*;

@Entity
@Table(name = "CARGOS")
public class Role extends AbstractEntity<Long> {

	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "id_department_fk")
	private Department department;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
}
