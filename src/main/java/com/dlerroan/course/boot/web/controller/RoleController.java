package com.dlerroan.course.boot.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
		return "cargo/cadastro";
	}
	
	@GetMapping("/listar")
	public String findAll(ModelMap model) {
		model.addAttribute("cargos", roleService.findAll());
		return "cargo/lista";
	}
	
	@PostMapping("/salvar")
	public String save(@Valid Role role, BindingResult result, RedirectAttributes attr) {
		
		if(result.hasErrors()) {
			return "cargo/cadastro";
		}
		
		roleService.save(role);
		attr.addFlashAttribute("success", "Cargo inserido com sucesso");
		return "redirect:/cargos/cadastrar";
	}
	
	@ModelAttribute("departamentos")
	public List<Department> departmentList(){
		return departmentService.findAll();
	}
	
	@GetMapping("/editar/{id}")
	public String preUpdate(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("role", roleService.findById(id));
		return "cargo/cadastro";
	}
	
	@PostMapping("/editar")
	public String update(@Valid Role role, BindingResult result, RedirectAttributes attr) {
		
		if(result.hasErrors()) {
			return "cargo/cadastro";
		}
		
		roleService.update(role);
		attr.addFlashAttribute("success", "Registro atualizado com sucesso.");
		return "redirect:/cargos/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String delete(@PathVariable("id") Long id, RedirectAttributes attr) {
		if(roleService.roleHasEmployee(id)) {
			attr.addFlashAttribute("fail", "Cargo não removido. Possui cargo(s) vinculado(s).");
		}else {
			roleService.delete(id);
			attr.addFlashAttribute("success", "Cargo excluído com sucesso");
		}
		return "redirect:/cargos/listar";
	}

}
