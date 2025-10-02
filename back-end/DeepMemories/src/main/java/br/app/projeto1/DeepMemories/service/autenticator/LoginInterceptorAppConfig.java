package br.app.projeto1.DeepMemories.service.autenticator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginInterceptorAppConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor logininterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logininterceptor)
            .addPathPatterns("/**") // intercepta todas as rotas
            .excludePathPatterns(
                "/login",             // página de login
                "/logar",             // envio de login
                "/CreateAccount",     // página de cadastro (corrigido o "C" minúsculo que você tinha colocado)
                "/css/**",            // arquivos de estilo
                "/js/**",             // scripts JS
                "/images/**",         // imagens
                "/error",             // página de erro padrão
                "/favicon.ico",        // ícone do navegador (pra evitar requisição inútil)
                "/",
                "/comentarios"
                
            );
    }
}
