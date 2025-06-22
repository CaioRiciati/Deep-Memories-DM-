package br.com.DM.deepMemories.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.DM.deepMemories.DAO.IUsuario;
import br.com.DM.deepMemories.entity.Usuario;


@RestController
public class usuarioController {
	
	@Autowired
	private IUsuario dao;

		@GetMapping("usuarios")
		public List<Usuario> listaUsuarios() {
			return (List<Usuario>) dao.findAll();
		}
}
