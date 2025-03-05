package com.example.GerenciamentoFuncionarios;

import com.example.GerenciamentoFuncionarios.model.Funcionario;
import com.example.GerenciamentoFuncionarios.service.GerenciadorFuncionario;


public class GerenciamentoFuncionariosApplication {

    public static void main(String[] args) {
        GerenciadorFuncionario funcionario = new GerenciadorFuncionario();

        funcionario.add(new Funcionario(1L, "joao", 3000.00));
        funcionario.add(new Funcionario(2L, "Jean", 15000.00));

        System.out.println("Funcionários cadastrados:");
        System.out.println(funcionario.listar());

        System.out.println("atualizando funcionario Jean");
        funcionario.atualizar(2L, 3500);
        System.out.println(funcionario.listar());

        System.out.println("Deletando funcionario Joao");
        funcionario.remove(1L);
        System.out.println(funcionario.listar());
    }

}
