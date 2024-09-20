package com.example.login_api.repo;

import com.example.login_api.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepo extends JpaRepository<Produto, Long> {
    List<Produto> findByNomeContaining(String nome);
}
