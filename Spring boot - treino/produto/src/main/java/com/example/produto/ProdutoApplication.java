package com.example.produto;

import com.example.produto.model.Produto;
import com.example.produto.service.GerenciarProduto;

public class ProdutoApplication {

    public static void main(String[] args) {
        GerenciarProduto produto = new GerenciarProduto();

        produto.add(new Produto(1l, "camiseta", 30.00, 3));
        produto.add(new Produto(2l, "geladeira", 40.00, 4));

        System.out.println(produto.listar());

        produto.atualizar(2L, 9.00, 0);
        System.out.println(produto.listar());

        produto.remove(1l);
        System.out.println(produto.listar());

    }
}
