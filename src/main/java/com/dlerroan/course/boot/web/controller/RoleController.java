package com.dlerroan.course.boot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cargos")
public class RoleController {
	
	@GetMapping("/cadastrar")
	public String insert() {
		return "/cargo/cadastro";
	}
	
	@GetMapping("/listar")
	public String findAll() {
		return "/cargo/lista";
	}

}
