/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Algaworks.osworks.Osworksapi.domain.repository;

import com.Algaworks.osworks.Osworksapi.domain.model.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author VAMARAL
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente , Long>{
    
    // Pesquisa pelo exato nome 
    List<Cliente> findByNome(String nome);
    
    // Pesquisa pela igualdade de caracteres
    List<Cliente> findByNomeContaining(String nome);
}
