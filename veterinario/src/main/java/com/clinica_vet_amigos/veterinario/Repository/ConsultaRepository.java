package com.clinica_vet_amigos.veterinario.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinica_vet_amigos.veterinario.model.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    
}
