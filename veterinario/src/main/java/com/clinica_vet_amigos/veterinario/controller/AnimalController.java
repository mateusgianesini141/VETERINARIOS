package com.clinica_vet_amigos.veterinario.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.clinica_vet_amigos.veterinario.Repository.AnimalRepository;
import com.clinica_vet_amigos.veterinario.model.Animal;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/animais")
public class AnimalController {

    private final AnimalRepository animalRepository;

    public AnimalController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

 @GetMapping("/ANIMAIS")
    public String listarAnimais(
        HttpSession sessao, 
        Model model, 
        @RequestParam(required = false) String buscaAnimal) {
            
        if (sessao.getAttribute("VETERINARIO") == null)
            return "redirect:/login";

        List<Animal> Animais;
        if (buscaAnimal != null && !buscaAnimal.isBlank())
            Animais = animalRepository.findByNomeContainingIgnoreCase(buscaAnimal);
        else
            Animais = animalRepository.findAll();

        model.addAttribute("animais", Animais);

        return "animais/lista";
    }

    @PostMapping("/salvar")
    public String salvarAnimal(@ModelAttribute Animal animal, HttpSession session) {

        if (session.getAttribute("usuarioLogado") == null) {
            return "redirect:/auth/login";
        }
        animalRepository.save(animal);

        return "redirect:/animais";
    }


    @GetMapping("/editar/{id}")
    public String editarAnimal(@PathVariable Long id, Model model, HttpSession session) {

        if (session.getAttribute("usuarioLogado") == null) {
            return "redirect:/auth/login";
        }

        Animal animal = animalRepository.findById(id).orElse(null);

        if (animal == null) {
            return "redirect:/animais";
        }

        model.addAttribute("animal", animal);

        return "editar-animal";
    }
        

        

    @GetMapping("/excluir/{id}")
    public String excluirAnimal(@PathVariable Long id, HttpSession session) {


        if (session.getAttribute("usuarioLogado") == null) {
            return "redirect:/auth/login" ; 
        }

        animalRepository.deleteById(id);        


        return "redirect:/animais";
    }



}