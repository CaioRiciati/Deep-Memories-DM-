package br.app.projeto1.DeepMemories.DAO;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.app.projeto1.DeepMemories.model.Usuario;

public interface IUsuario extends CrudRepository<Usuario, Integer>{

	@Query(value= "select * from deepmemories.usuarionovo where email = :email and senha = :senha", nativeQuery = true)
	public Usuario login(String email, String senha);
	
}
