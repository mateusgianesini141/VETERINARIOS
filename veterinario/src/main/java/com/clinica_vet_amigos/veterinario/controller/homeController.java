package com.clinica_vet_amigos.veterinario.controller;

import com.clinica_vet_amigos.veterinario.model.Consulta;
import com.clinica_vet_amigos.veterinario.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/consultas")
public class homeController {

    @Autowired
    private ConsultaService consultaService;

    @GetMapping("/")
    public String home() {
    return "redirect:/consultas";
    }

    @GetMapping("/nova")
    public String novaConsulta1(Model model) {
    model.addAttribute("consulta", new Consulta());
    return "consultas/form";
    }

    // Listar consultas
    @GetMapping
    public String listarConsultas(Model model) {
    model.addAttribute("consultas", consultaService.listarTodas());
    return "consultas/lista";
    }

    // Formulário nova consulta
    @GetMapping("/nova")
    public String novaConsulta(Model model) {
    model.addAttribute("consulta", new Consulta());
    return "consultas/form";
    }

    // Salvar consulta
    @PostMapping("/salvar")
    public String salvarConsulta(@ModelAttribute Consulta consulta) {
    consultaService.salvar(consulta);
    return "redirect:/consultas";
    }

    // Editar consulta
    @GetMapping("/editar/{id}")
    public String editarConsulta(@PathVariable Long id, Model model) {
    model.addAttribute("consulta", consultaService.buscarPorId(id));
    return "consultas/form";
    }

    // Excluir consulta
    @GetMapping("/excluir/{id}")
    public String excluirConsulta(@PathVariable Long id) {
    consultaService.excluir(id);
    return "redirect:/consultas";
    }
}