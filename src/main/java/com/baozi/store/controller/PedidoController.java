package com.baozi.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baozi.store.model.Cliente;
import com.baozi.store.model.Pedido;
import com.baozi.store.model.Produto;
import com.baozi.store.repository.ClienteRepository;
import com.baozi.store.repository.PedidoRepository;
import com.baozi.store.repository.ProdutoRepository;

// No POST do pedido o JSON manda so o id do cliente e do produto
// exemplo: "cliente": { "id": 1 }
@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    // Preciso dos outros dois repositorios pra buscar o cliente e o produto
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    // POST /pedidos
    @PostMapping
    public Pedido cadastrar(@RequestBody Pedido pedido) {
        // Como o JSON so manda o id, busco os dados completos no banco
        Cliente cliente = clienteRepository.findById(pedido.getCliente().getId()).orElse(null);
        Produto produto = produtoRepository.findById(pedido.getProduto().getId()).orElse(null);

        pedido.setCliente(cliente);
        pedido.setProduto(produto);

        return pedidoRepository.save(pedido);
    }

    // GET /pedidos
    @GetMapping
    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    // GET /pedidos/1
    @GetMapping("/{id}")
    public Pedido buscarPorId(@PathVariable Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    // DELETE /pedidos/1
    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id) {
        pedidoRepository.deleteById(id);
        return "Pedido deletado";
    }
}
