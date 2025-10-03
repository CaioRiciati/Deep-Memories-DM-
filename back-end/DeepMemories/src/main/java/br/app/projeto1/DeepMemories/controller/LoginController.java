       package br.app.projeto1.DeepMemories.controller;

import java.io.UnsupportedEncodingException;

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
import br.app.projeto1.DeepMemories.service.CookieService;
import jakarta.servlet.http.HttpServletRequest;
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
	
	@GetMapping("/jogo")
	public String jogos() {
		return"jogo";
		
	}
	
    @GetMapping("/")
    public String dashboard(Model model, HttpServletRequest request) throws UnsupportedEncodingException {
        String nomeUsuario = CookieService.getCookie(request, "nomeUsuario");
        if (nomeUsuario != null) {
            model.addAttribute("nomeUsuario", nomeUsuario);
            return "home";
        }
        return "home";
    }
	
	
	@PostMapping("/logar")
	public String loginUsuario(Usuario usuario, Model model, HttpServletResponse response) throws UnsupportedEncodingException {
		Usuario usuarioLogado = this.ur.login(usuario.getEmail(), usuario.getSenha());
		if(usuarioLogado != null) {
			CookieService.setCookie(response, "usuarioId", String.valueOf(usuarioLogado.getId()), 10000);
			CookieService.setCookie(response, "nomeUsuario", String.valueOf(usuarioLogado.getNome()), 10000);
			return "redirect:/";
		}
		
		model.addAttribute("erro", "usuario invalido!!");
		return "login";
	}
	
	
	
	
	

	@GetMapping("/CreateAccount")
	public String CreateAccount() {
		return "CreateAccount";
	}
	
	
	@RequestMapping(value = "/CreateAccount", method = RequestMethod.POST)
	public String cadastroUsuario(@Valid Usuario usuario, BindingResult result) {	
		if(result.hasErrors()) {
			return "login";
		}

		ur.save(usuario);
		return "redirect:/login";
		
	}
}