package com.dlerroan.course.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@GetMapping("/editar/{id}")
	public String preUpdate(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("department", service.findById(id));
		return "/departamento/cadastro";
	}
	
	@PostMapping("/salvar")
	public String save(Department department, RedirectAttributes attr) {
		service.save(department);
		attr.addFlashAttribute("success", "Departamento inserido com sucesso.");
		return "redirect:/departamentos/cadastrar";
	}
	
	@PostMapping("/editar")
	public String update(Department department, RedirectAttributes attr) {
		service.update(department);
		attr.addFlashAttribute("success", "Registro atualizado com sucesso.");
		return "redirect:/departamentos/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String delete(@PathVariable("id") Long id, ModelMap model) {
		if(service.departmentHasRole(id)) {
			model.addAttribute("fail", "Departamento não removido. Possui cargo(s) vinculado(s).");
		}else {
			service.delete(id);
			model.addAttribute("success", "Departamento excluído com sucesso");
		}
		return findAll(model);
	}
}
