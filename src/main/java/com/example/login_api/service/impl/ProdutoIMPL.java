package com.example.login_api.service.impl;

import com.example.login_api.dto.ProdutoDTO;
import com.example.login_api.entity.Produto;
import com.example.login_api.repo.ProdutoRepo;
import com.example.login_api.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoIMPL implements ProdutoService {

    private final ProdutoRepo produtoRepo;

    @Autowired
    public ProdutoIMPL(ProdutoRepo produtoRepo) {
        this.produtoRepo = produtoRepo;
    }

    private ProdutoDTO convertToDTO(Produto produto) {
        if (produto == null) {
            return null;
        }
        return new ProdutoDTO(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getLinkImagem(),
                produto.getValor(),
                produto.getQuantidade()
        );
    }

    private Produto convertToEntity(ProdutoDTO produtoDTO) {
        if (produtoDTO == null) {
            return null;
        }
        Produto produto = new Produto();
        produto.setId(produtoDTO.getId());
        produto.setNome(produtoDTO.getNome());
        produto.setDescricao(produtoDTO.getDescricao());
        produto.setLinkImagem(produtoDTO.getLinkImagem());
        produto.setValor(produtoDTO.getValor());
        produto.setQuantidade(produtoDTO.getQuantidade());
        return produto;
    }

    @Override
    public List<ProdutoDTO> listarProdutos() {
        return produtoRepo.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProdutoDTO obterProduto(Long id) {
        return produtoRepo.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    @Override
    public ProdutoDTO adicionarProduto(ProdutoDTO produtoDTO) {
        Produto produto = convertToEntity(produtoDTO);
        Produto savedProduto = produtoRepo.save(produto);
        return convertToDTO(savedProduto);
    }

    @Override
    public ProdutoDTO atualizarProduto(Long id, ProdutoDTO produtoDTO) {
        Produto existingProduto = produtoRepo.findById(id).orElse(null);
        if (existingProduto != null) {
            existingProduto.setNome(produtoDTO.getNome());
            existingProduto.setDescricao(produtoDTO.getDescricao());
            existingProduto.setLinkImagem(produtoDTO.getLinkImagem());
            existingProduto.setValor(produtoDTO.getValor());
            existingProduto.setQuantidade(produtoDTO.getQuantidade());
            Produto updatedProduto = produtoRepo.save(existingProduto);
            return convertToDTO(updatedProduto);
        }
        return null;
    }

    @Override
    public void deletarProduto(Long id) {
        produtoRepo.deleteById(id);
    }

    @Override
    public List<ProdutoDTO> buscarPorNome(String nome) {
        return produtoRepo.findByNomeContaining(nome).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deletarProdutoPorNome(String nome) {
        List<Produto> produtos = produtoRepo.findByNomeContaining(nome);
        if (!produtos.isEmpty()) {
            produtoRepo.deleteAll(produtos);
        }
    }


}
