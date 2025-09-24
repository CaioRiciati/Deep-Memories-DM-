package br.app.projeto1.DeepMemories.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String texto;

    private String nomeUsuario; // Ou você pode usar relação com Usuario, se quiser

    private LocalDateTime dataHora;

    public Comentario() {}

    public Comentario(String texto, String nomeUsuario) {
        this.texto = texto;
        this.nomeUsuario = nomeUsuario;
        this.dataHora = LocalDateTime.now();
    }

    // Getters e setters
}
