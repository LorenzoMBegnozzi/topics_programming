package com.example.Cliente.service;

import com.example.Cliente.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class GerenciarCliente {
    List<Cliente> clientes = new ArrayList<>();

    public void create(Cliente cliente){
        clientes.add(cliente);
    }

    public List<Cliente> list(){
        return clientes;
    }

    public void delete(Long id){
        clientes.removeIf(cliente -> cliente.getId().equals(id));
    }

    public Cliente atuaizar (Long id, String email, String telefone){
        for (Cliente cliente : clientes){
            if (cliente.getId().equals(id)) {
                cliente.setEmail(email);
                cliente.setTelefone(telefone);
            }
        }
        return null;
    }
}
