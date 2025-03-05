package com.example.Cliente.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString

public class Cliente {
    private Long id;

    private String nome;

    private String email;

    private String telefone;
}
