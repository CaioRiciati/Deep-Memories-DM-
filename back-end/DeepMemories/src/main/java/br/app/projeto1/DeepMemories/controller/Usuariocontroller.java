package br.app.projeto1.DeepMemories.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Usuariocontroller {
	@GetMapping("/usuario")
	public String texto () {
		return "acessando a api";
		
	}
	
}
