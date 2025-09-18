package br.app.projeto1.DeepMemories.repository;

import org.springframework.data.repository.CrudRepository;

import br.app.projeto1.DeepMemories.model.Usuario;

public interface UsuarioRepository  extends CrudRepository<Usuario, String>{

}
