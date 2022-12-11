package com.example.SistemaVichayalSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String getEscritorio() {
		return "escritorio";
	}
	
	@GetMapping("/Roles")
	public String getRol() {
		return "rol";
	}
	
	
}
