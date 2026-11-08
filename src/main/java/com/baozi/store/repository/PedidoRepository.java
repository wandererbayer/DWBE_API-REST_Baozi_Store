package com.baozi.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baozi.store.model.Pedido;

// Mesma coisa dos outros dois
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
