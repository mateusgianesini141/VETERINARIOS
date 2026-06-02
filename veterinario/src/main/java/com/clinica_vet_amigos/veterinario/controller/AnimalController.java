package com.clinica_vet_amigos.veterinario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.clinica_vet_amigos.veterinario.Repository.AnimalRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/animais")
public class AnimalController {

    private final AnimalRepository animalRepository;

    public AnimalController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @GetMapping
    public String listarAnimais(Model model, HttpSession session) {

        if (session.getAttribute("usuarioLogado") == null) {
            return "redirect:/auth/login";
        }

        model.addAttribute("animais", animalRepository.findAll());
        return "animais";
    }
}