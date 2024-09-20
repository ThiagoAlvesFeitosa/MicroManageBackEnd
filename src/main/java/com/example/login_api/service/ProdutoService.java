package com.example.login_api.service;

import com.example.login_api.dto.ProdutoDTO;

import java.util.List;

public interface ProdutoService {
    List<ProdutoDTO> listarProdutos();
    ProdutoDTO obterProduto(Long id);
    ProdutoDTO adicionarProduto(ProdutoDTO produtoDTO);
    ProdutoDTO atualizarProduto(Long id, ProdutoDTO produtoDTO);
    void deletarProduto(Long id);
    List<ProdutoDTO> buscarPorNome(String nome);
    void deletarProdutoPorNome(String nome);

}
