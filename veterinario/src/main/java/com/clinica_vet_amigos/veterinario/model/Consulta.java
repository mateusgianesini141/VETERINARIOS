package com.clinica_vet_amigos.veterinario.model;

import jakarta.persistence.*;

@Entity
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "veterinario_id")
    private Veterinario veterinario;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Object getDataConsulta() {
        return null;
    }

    public Object getHoraConsulta() {
        return null;
    }

    public Object getObservacoes() {
        return null;
    }

    public Object getDiagnostico() {
        return null;
    }

    public Object getTratamento() {
        return null;
    }

    public Object getValor() {
        return null;
    }

    public Object getStatus() {
        return null;
    }

    public Object getTemperaturaAnimal() {
        return null;
    }

    public void setDataConsulta(Object dataConsulta) {
      return;
    }

    public void setHoraConsulta(Object horaConsulta) {
        return;
    }

    public void setDiagnostico(Object diagnostico) {
        return;
    }

    public void setObservacoes(Object observacoes) {
        return;
    }

    public void setTratamento(Object tratamento) {
        return;
    }

    public void setValor(Object valor) {
        return;
    }

    public void setStatus(Object status) {
        return;
    }

    public void setPesoAnimal(Animal animal2) {
        return;
    }

    public void setTemperaturaAnimal(Object temperaturaAnimal) {
        return;
}
}