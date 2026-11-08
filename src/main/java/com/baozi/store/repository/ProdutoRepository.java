package com.baozi.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baozi.store.model.Produto;

// Mesma coisa do ClienteRepository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
