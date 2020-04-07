package com.dlerroan.course.boot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dlerroan.course.boot.domain.Department;
import com.dlerroan.course.boot.domain.Role;
import com.dlerroan.course.boot.service.DepartmentService;
import com.dlerroan.course.boot.service.RoleService;

@Controller
@RequestMapping("/cargos")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/cadastrar")
	public String insert(Role role) {
		return "/cargo/cadastro";
	}
	
	@GetMapping("/listar")
	public String findAll(ModelMap model) {
		model.addAttribute("cargos", roleService.findAll());
		return "/cargo/lista";
	}
	
	@PostMapping("/salvar")
	public String save(Role role, RedirectAttributes attr) {
		roleService.save(role);
		attr.addFlashAttribute("success", "Cargo inserido com sucesso");
		return "redirect:/cargos/cadastrar";
	}
	
	@ModelAttribute("departamentos")
	public List<Department> departmentList(){
		return departmentService.findAll();
	}

}
