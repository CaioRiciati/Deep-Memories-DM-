package br.app.projeto1.DeepMemories.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty
	private String nome;
	
	@NotEmpty
	private String username;
	
	@NotEmpty
	private String email;
	
	@NotEmpty
	private String senha;
	

}