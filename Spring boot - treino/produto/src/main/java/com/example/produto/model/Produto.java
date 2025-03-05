package com.example.produto.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class Produto {

    private Long id;

    private String nome;

    private Double preco;

    private Integer quantidade;
}
