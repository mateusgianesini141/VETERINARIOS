package com.clinica_vet_amigos.veterinario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/auth")
public class LoginController {

    @GetMapping("/login")
    public String telaLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String fazerLogin(
            @RequestParam String usuario,
            @RequestParam String senha,
            HttpSession session,
            Model model) {

        if ("admin".equals(usuario) && "123".equals(senha)) {
            session.setAttribute("usuarioLogado", usuario);
            return "redirect:/animais";
        }

        model.addAttribute("erro", "Usuário ou senha inválidos!");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/auth/login";
    }
}