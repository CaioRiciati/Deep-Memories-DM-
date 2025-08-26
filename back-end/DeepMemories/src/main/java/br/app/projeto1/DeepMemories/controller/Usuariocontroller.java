package br.app.projeto1.DeepMemories.controller;


public class Usuariocontroller {
	@GetMapping("/usuario")
	public String texto () {
		return "acessando a api";
	}
}
