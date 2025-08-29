package br.app.projeto1.DeepMemories.DAO;

import org.springframework.data.repository.CrudRepository;

import br.app.projeto1.DeepMemories.model.Usuario;

public interface IUsuario extends CrudRepository<Usuario, Integer>{

}
