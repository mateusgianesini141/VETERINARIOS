package com.clinica_vet_amigos.veterinario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.clinica_vet_amigos.veterinario.Repository.ConsultaRepository;
import com.clinica_vet_amigos.veterinario.model.Consulta;

@Controller
@RequestMapping("/consultas")
public class ConsultaController {

    private final ConsultaRepository consultaRepository;

    public ConsultaController(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    @GetMapping
    public String listarConsultas(Model model) {
        model.addAttribute("consultas", consultaRepository.findAll());
        return "consultas/lista";
    }

    @GetMapping("/nova")
    public String novaConsulta(Model model) {
        model.addAttribute("consulta", new Consulta());
        return "consultas/form";
    }

    @PostMapping("/salvar")
    public String salvarConsulta(@ModelAttribute Consulta consulta) {
        consultaRepository.save(consulta);
        return "redirect:/consultas";
    }

    @GetMapping("/editar/{id}")
    public String editarConsulta(@PathVariable Long id, Model model) {

        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Consulta não encontrada"));

        model.addAttribute("consulta", consulta);

        return "consultas/form";
    }

    @GetMapping("/excluir/{id}")
    public String excluirConsulta(@PathVariable Long id) {

        consultaRepository.deleteById(id);

        return "redirect:/consultas";
    }
}