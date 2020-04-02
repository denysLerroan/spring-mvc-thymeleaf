package com.dlerroan.course.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dlerroan.course.boot.domain.Department;
import com.dlerroan.course.boot.service.DepartmentService;

@Controller
@RequestMapping("/departamentos")
public class DepartmentController {
	
	@Autowired
	private DepartmentService service;

	@GetMapping("/cadastrar")
	public String insert(Department department) {
		return "/departamento/cadastro";
	}
	
	@GetMapping("/listar")
	public String findAll(ModelMap model) {
		model.addAttribute("departamentos", service.findAll());
		return "/departamento/lista";
	}
	
	@PostMapping("/salvar")
	public String save(Department department) {
		service.save(department);
		return "redirect:/departamentos/cadastrar";
	}
}
