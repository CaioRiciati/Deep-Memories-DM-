package br.app.projeto1.DeepMemories.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.app.projeto1.DeepMemories.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String> {

		Usuario findById(long id);
		
		@Query(value="selet * from deepmemories.usuario where emai = :email and senha = :senha", nativeQuery = true)
		public Usuario login(String email, String senha);
		
}
