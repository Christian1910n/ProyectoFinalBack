package com.example.cursospring.service;

import com.example.cursospring.entity.Pedido_cliente;
import com.example.cursospring.repository.PedidoClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoClienteServiceImp  implements PedidoClienteService{

    @Autowired
    private PedidoClienteRepository pedidoClienteRepository;
    @Override
    public List<Pedido_cliente> findAll() {
        return (List<Pedido_cliente>) pedidoClienteRepository.findAll();
    }

    @Override
    public Pedido_cliente save(Pedido_cliente c) {
        return pedidoClienteRepository.save(c);
    }

    @Override
    public Pedido_cliente findById(Integer id) {
        return pedidoClienteRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        pedidoClienteRepository.deleteById(id);
    }
}
