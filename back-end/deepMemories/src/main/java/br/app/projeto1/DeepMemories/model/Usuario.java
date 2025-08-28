package br.app.projeto1.DeepMemories.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "usuarionovo")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name", length= 140, nullable = false)
	private String name;
	
	@Column(name = "username", length= 20, nullable = false)	
	private String username;
	
	@Column(name = "password", columnDefinition = "TEXT" , nullable = false)
	private String password;
	
	@Column(name = "email", length= 45, nullable = false)
	private String email;
	
	@Column(name = "deepcoins", length= 10, nullable = false)
	private Integer deepcoins;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getDeepcoins() {
		return deepcoins;
	}
	public void setDeepcoins(Integer deepcoins) {
		this.deepcoins = deepcoins;
	}
	
	
}
