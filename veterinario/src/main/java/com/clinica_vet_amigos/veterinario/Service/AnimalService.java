package com.clinica_vet_amigos.veterinario.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clinica_vet_amigos.veterinario.Repository.AnimalRepository;
import com.clinica_vet_amigos.veterinario.model.Animal;


@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public Animal buscarPorId(Long id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal não encontrado"));
    }

    public Animal salvar(Animal animal) {
        return animalRepository.save(animal);
    }
    
    public void excluir(Long id) {

    Animal animal = animalRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Animal não encontrado"));

    animalRepository.delete(animal);
}
}