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
import com.baozi.store.repository.ClienteRepository;

// O @RestController faz os metodos devolverem JSON
// O @RequestMapping e o inicio do endereco de todos os metodos daqui
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    // O Spring cria o repositorio pra mim por causa do @Autowired
    @Autowired
    private ClienteRepository clienteRepository;

    // POST /clientes
    @PostMapping
    public Cliente cadastrar(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // GET /clientes
    @GetMapping
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    // GET /clientes/1
    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable Long id) {
        // Se nao achar o cliente devolve vazio
        return clienteRepository.findById(id).orElse(null);
    }

    // DELETE /clientes/1
    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id) {
        clienteRepository.deleteById(id);
        return "Cliente deletado";
    }
}
