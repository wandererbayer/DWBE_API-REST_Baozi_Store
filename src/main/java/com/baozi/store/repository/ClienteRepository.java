package com.baozi.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baozi.store.model.Cliente;

// o JpaRepository ja traz save, findAll, findById e deleteById prontos
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
