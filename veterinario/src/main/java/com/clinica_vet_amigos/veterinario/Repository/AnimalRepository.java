package com.clinica_vet_amigos.veterinario.Repository;

    
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinica_vet_amigos.veterinario.model.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

        
    List<Animal> findByNomeContainingIgnoreCase(String buscaProduto);
}