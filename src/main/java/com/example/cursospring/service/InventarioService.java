package com.example.cursospring.service;

import com.example.cursospring.entity.Inventario;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface InventarioService {
    public Iterable<Inventario> findAll();
    public Page<Inventario> findAll(Pageable pageable);
    public Inventario findById(Integer id);
    public Inventario save(Inventario user);
    public void deleteById(Integer id);

    public List<Inventario> findAllByNombreLike(String titulo);
}
