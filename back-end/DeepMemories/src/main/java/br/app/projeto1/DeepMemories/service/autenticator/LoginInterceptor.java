package br.app.projeto1.DeepMemories.service.autenticator;

import java.io.IOException;

import org.springframework.web.servlet.HandlerInterceptor;

import br.app.projeto1.DeepMemories.service.CookieService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor{
	
	
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler ) throws IOException {
		 if(CookieService.getCookie(request, "usuarioId") != null) {
			 return true;
		 }
		 
		 response.sendRedirect("/login");
		 return false;
	}

}
