package com.example.Cliente;

import com.example.Cliente.model.Cliente;
import com.example.Cliente.service.GerenciarCliente;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClienteApplication {

    public static void main(String[] args) {
        GerenciarCliente cliente = new GerenciarCliente();

        cliente.create(new Cliente(1L, "Pedro", "pedro@teste.com","4498989898"));
        cliente.create(new Cliente(2L, "Lucas", "lucas@teste.com","23123323233"));

        System.out.println(cliente.list());

        cliente.atuaizar(1L, "pedroAtualizado@testeAtualizado.com", "12323133123");
        System.out.println(cliente.list());

        cliente.delete(1L);
        System.out.println(cliente.list());

    }
}
