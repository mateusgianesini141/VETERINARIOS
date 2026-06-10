package com.clinica_vet_amigos.veterinario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica_vet_amigos.veterinario.Repository.ConsultaRepository;
import com.clinica_vet_amigos.veterinario.model.Consulta;

@Service
public class ConsultaService<consultaRepository> {

    @Autowired
    private ConsultaRepository consultaRepository;

    // Listar todas as consultas
    public List<Consulta> listarTodas() {
        return consultaRepository.findAll();
    }

    // Salvar consulta
    public Consulta salvar(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    // Buscar consulta por ID
    public Consulta buscarPorId(Long id) {
        return consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada com ID: " + id));
    }

    // Atualizar consulta
    public <consultaRepository> Consulta atualizar(Long id, Consulta consultaAtualizada) {
        Consulta consulta = buscarPorId(id);

        consulta.setNomeAnimal(consultaAtualizada.getNomeAnimal());
        consulta.setNomeTutor(consultaAtualizada.getNomeTutor());
        consulta.setVeterinario(consultaAtualizada.getVeterinario());
        consulta.setDataConsulta(consultaAtualizada.getDataConsulta());
        consulta.setObservacoes(consultaAtualizada.getObservacoes());

        return consultaRepository.save(consulta);
    }

    // Excluir consulta
    public void excluir(Long id) {
        Consulta consulta = buscarPorId(id);
        consultaRepository.delete(consulta);
    }

        
}