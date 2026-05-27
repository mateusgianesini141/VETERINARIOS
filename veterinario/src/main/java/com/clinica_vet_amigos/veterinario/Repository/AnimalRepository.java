package com.clinica_vet_amigos.veterinario.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinica_vet_amigos.veterinario.model.Animal;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    List<Animal> findByNomeContainingIgnoreCase(String nome);

}