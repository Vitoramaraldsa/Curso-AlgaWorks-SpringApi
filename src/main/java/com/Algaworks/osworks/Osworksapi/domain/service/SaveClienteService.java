/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Algaworks.osworks.Osworksapi.domain.service;

import com.Algaworks.osworks.Osworksapi.domain.exception.BusinessException;
import com.Algaworks.osworks.Osworksapi.domain.model.Cliente;
import com.Algaworks.osworks.Osworksapi.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author VAMARAL
 */
@Service
public class SaveClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    public Cliente save(Cliente c){
        Cliente clientExist = clienteRepository.findByEmail(c.getEmail());
        if(clientExist != null && !clientExist.equals(c)){
           throw new BusinessException("Já exite um cliente cadastrado com este e-mail ! ");
        }
            return clienteRepository.save(c);
      
     }
    
    public void delete(long id){
       clienteRepository.deleteById(id);
    }
}
