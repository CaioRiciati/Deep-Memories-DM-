       package br.app.projeto1.DeepMemories.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.app.projeto1.DeepMemories.model.Usuario;
import br.app.projeto1.DeepMemories.repository.UsuarioRepository;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;


@Controller
public class LoginController {
	
	@Autowired
	private UsuarioRepository ur;
	
	@GetMapping("/login")
	public String login() {
		return"login";
		
	}
	
	@GetMapping("/")
	public String dashboard() {
		return "index";
	}
	
	@PostMapping("/logar")
	
	public String loginUsuario(Usuario usuario, Model model, HttpServletResponse response) {
		Usuario usuarioLogado = this.ur.login(usuario.getEmail(), usuario.getSenha());
		if(usuarioLogado != null) {
			return "redirect:/";
		}
		
		model.addAttribute("erro", "usuario invalido!!");
		return "login";
	}
	
	
	
	
	
	
	//aki é o cadastro de usuario mas eu coloquei create account p ficar mais intuitivo
	@GetMapping("/CreateAccount")
	public String CreateAccount() {
		return "CreateAccount";
	}
	
	@RequestMapping(value = "/cadastroUsuario", method = RequestMethod.POST)
	public String cadastroUsuario(@Valid Usuario usuario, BindingResult result) {
		
		if(result.hasErrors()) {
			return "redirect:cadastroUsuario";
		}
		
		ur.save(usuario);

		return "redirect:/login";
		
	}
}