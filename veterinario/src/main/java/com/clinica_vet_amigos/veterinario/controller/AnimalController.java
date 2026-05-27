package com.clinica_vet_amigos.veterinario.controller;


import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.clinica_vet_amigos.veterinario.Repository.AnimalRepository;
import com.clinica_vet_amigos.veterinario.model.Animal;

import java.util.List;

@Controller
public class AnimalController {

    @Autowired
    private AnimalRepository animalRepository;

    // LISTAGEM + BUSCA
    @GetMapping("/animais")
    public String listarAnimais(
            @RequestParam(required = false) String busca,
            Model model,
            HttpSession session) {

        // Proteção da rota
        if (session.getAttribute("usuarioLogado") == null) {
            return "redirect:/login";
        }

        List<Animal> animais;

        if (busca != null && !busca.isEmpty()) {
            animais = animalRepository.findByNomeContainingIgnoreCase(busca);
        } else {
            animais = animalRepository.findAll();
        }

        model.addAttribute("animais", animais);
        model.addAttribute("busca", busca);

        return "animais";
    }

    // SALVAR ANIMAL
    @PostMapping("/animais/salvar")
    public String salvarAnimal(
            @ModelAttribute Animal animal,
            HttpSession session) {

        // Proteção da rota
        if (session.getAttribute("usuarioLogado") == null) {
            return "redirect:/login";
        }

        animalRepository.save(animal);

        // Redireciona para atualizar tabela
        return "redirect:/animais";
    }
}