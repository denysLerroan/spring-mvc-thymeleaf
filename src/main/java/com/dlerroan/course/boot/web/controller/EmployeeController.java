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

import com.dlerroan.course.boot.domain.Employee;
import com.dlerroan.course.boot.domain.Role;
import com.dlerroan.course.boot.domain.UF;
import com.dlerroan.course.boot.service.EmployeeService;
import com.dlerroan.course.boot.service.RoleService;

@Controller
@RequestMapping("/funcionarios")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping("/cadastrar")
	public String insert(Employee employee) {
		return "/funcionario/cadastro";
	}
	
	@GetMapping("/listar")
	public String findAll(ModelMap model) {
		model.addAttribute("funcionarios", employeeService.findAll());
		return "/funcionario/lista";
	}
	
	@PostMapping("/salvar")
	public String save(Employee employee, RedirectAttributes attr) {
		employeeService.save(employee);
		attr.addFlashAttribute("success", "Funcionário inserido com sucesso");
		return "redirect:/funcionarios/cadastrar";
	}
	
	@ModelAttribute("cargos")
	public List<Role> getRoles(){
		return roleService.findAll();
	}
	
	@ModelAttribute("ufs")
	public UF[] getUFs() {
		return UF.values();
	}

}
