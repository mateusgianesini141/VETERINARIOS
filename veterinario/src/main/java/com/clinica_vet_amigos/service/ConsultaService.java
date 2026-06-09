package com.clinica_vet_amigos.service;

import java.util.List;



import org.springframework.stereotype.Service;

import com.clinica_vet_amigos.veterinario.Repository.ConsultaRepository;
import com.clinica_vet_amigos.veterinario.model.Consulta;

@Service
@RequiredArgsConstrutor

public class ConsultaService<consulta, consultaRepository> {
    private final ConsultaRepository consultaRepository = null;

    public List<consulta> listar(){
        return (List<consulta>) consultaRepository.findAll();
    }

        public Consulta buscarPorId(Long id){
            return consultaRepository.findById(id).orElseThrow(() -> new RuntimeException("Consulta não encontrada"));
        }
    public Consulta salvar(Consulta consulta){
        return consultaRepository.save(consulta);
    }
    public Consulta atualizar(long id, Consulta consulta){
        Consulta existente = buscarPorId(id);

        existente.setDataConsulta(consulta.getDataConsulta());
        existente.setHoraConsulta(consulta.getHoraConsulta());
        existente.setObservacoes(consulta.getObservacoes());
        existente.setDiagnostico(consulta.getDiagnostico());
        existente.setTratamento(consulta.getTratamento());
        existente.setValor(consulta.getValor());
        existente.setStatus(consulta.getStatus());
        existente.setPesoAnimal(consulta.getAnimal());
        existente.setTemperaturaAnimal(consulta.getTemperaturaAnimal());

        return consultaRepository.save(existente);

    }
    public void excluir(Long id){
        consultaRepository.deleteById(id);
       
    }
}

