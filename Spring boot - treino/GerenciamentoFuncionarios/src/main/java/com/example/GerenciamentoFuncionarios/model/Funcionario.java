package com.example.GerenciamentoFuncionarios.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class Funcionario {

    private Long id;

    private String name;

    private double salario;
}
