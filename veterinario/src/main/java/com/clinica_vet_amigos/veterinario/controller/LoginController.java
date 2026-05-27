package com.clinica_vet_amigos.veterinario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String abrirLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String fazerLogin(
            @RequestParam String usuario,
            @RequestParam String senha,
            Model model) {

        // usuário e senha corretos
        if(usuario.equals("admin") && senha.equals("123")) {

            model.addAttribute("mensagem", "Bem-vindo ao Sistema da Clínica Vet Amigos!");

            return "principal";
        }

        // senha errada
        model.addAttribute("erro", "Usuário ou senha inválidos!");

        return "login";
    }
}