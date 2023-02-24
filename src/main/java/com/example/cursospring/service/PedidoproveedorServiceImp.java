package com.example.cursospring.service;

import com.example.cursospring.entity.Pedido_proveedor;
import com.example.cursospring.entity.Usuario;
import com.example.cursospring.repository.PedidoProveedorRepository;
import com.example.cursospring.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PedidoproveedorServiceImp implements PedidoProveedorService{
    @Autowired
    private PedidoProveedorRepository userR;


    @Override
    @Transactional(readOnly=true)
    public Iterable<Pedido_proveedor> findAll() {
        return userR.findAll();
    }

    @Override
    public Pedido_proveedor findById(Integer id) {
        return userR.findById(id).orElse(null);
    }

    @Override
    public Pedido_proveedor save(Pedido_proveedor user) {
        return userR.save(user);
    }

    @Override
    public void deleteById(Integer id) {
        userR.deleteById(id);
    }
}
