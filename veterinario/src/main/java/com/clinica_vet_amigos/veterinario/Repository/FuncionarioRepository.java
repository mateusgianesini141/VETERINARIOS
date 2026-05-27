package com.clinica_vet_amigos.veterinario.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinica_vet_amigos.veterinario.model.Funcionario;



public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    //spring vai gerar: select *from funcionario where login = ?
   Funcionario findByLogin(String login);
    

    
}
