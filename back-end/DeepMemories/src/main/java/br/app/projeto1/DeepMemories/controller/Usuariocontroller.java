package br.app.projeto1.DeepMemories.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.app.projeto1.DeepMemories.DAO.IUsuario;
import br.app.projeto1.DeepMemories.model.Usuario;

@RestController
public class Usuariocontroller {
	
	@Autowired
	private IUsuario dao;
	
	@GetMapping("/usuario")
	public List<Usuario> listaUsuarios () {
		return (List<Usuario>) dao.findAll();
	}
	
}
