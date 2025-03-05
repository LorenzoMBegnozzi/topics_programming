package com.example.GerenciamentoFuncionarios.service;

import com.example.GerenciamentoFuncionarios.model.Funcionario;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class GerenciadorFuncionario {
    List<Funcionario> funcionarios = new ArrayList<>();

    public void add(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public List<Funcionario> listar() {
        return funcionarios;
    }

    public Funcionario atualizar(Long id, double salario) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getId().equals(id)) {
                funcionario.setSalario(salario);
                return funcionario;
            }
        }
        return null;
    }

        public void remove(Long id) {
            funcionarios.removeIf(funcionario -> funcionario.getId().equals(id));
        }
}
