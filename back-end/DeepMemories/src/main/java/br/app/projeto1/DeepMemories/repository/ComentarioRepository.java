package br.app.projeto1.DeepMemories.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.app.projeto1.DeepMemories.model.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
}
