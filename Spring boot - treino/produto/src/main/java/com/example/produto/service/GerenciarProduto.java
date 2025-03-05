package com.example.produto.service;

import com.example.produto.model.Produto;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class GerenciarProduto {
    List<Produto> produtos = new ArrayList<>();

    public void add(Produto produto) {
        produtos.add(produto);
    }

    public List<Produto> listar() {
        return produtos;
    }

    public void remove(Long id) {
        produtos.removeIf(produto -> produto.getId().equals(id));
    }

    public Produto atualizar(Long id, Double preco, Integer quantidade) {
        for (Produto produto : produtos) {
            if (produto.getId().equals(id)) {
                produto.setPreco(preco);
                produto.setQuantidade(quantidade);
                return produto;
            }
        }
        return null;
    }
}
