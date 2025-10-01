package br.app.projeto1.DeepMemories.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import br.app.projeto1.DeepMemories.model.Comentario;
import br.app.projeto1.DeepMemories.repository.ComentarioRepository;
import br.app.projeto1.DeepMemories.service.CookieService;

import jakarta.servlet.http.HttpServletRequest;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class ComentarioController {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @GetMapping("/comentarios")
    public String verComentarios(Model model) {
        List<Comentario> comentarios = comentarioRepository.findAll();
        model.addAttribute("comentarios", comentarios);
        return "comentarios";
    }

    @PostMapping("/comentarios")
    public String adicionarComentario(@RequestParam("texto") String texto, HttpServletRequest request) throws UnsupportedEncodingException {
        String nomeUsuario = CookieService.getCookie(request, "nomeUsuario");
        if (nomeUsuario == null || nomeUsuario.isEmpty()) {
            nomeUsuario = "Anônimo";
        }
        Comentario comentario = new Comentario(texto, nomeUsuario);
        comentarioRepository.save(comentario);
        return "redirect:/comentarios";
    }
}
