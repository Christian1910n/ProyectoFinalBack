package com.example.cursospring.repository;

import com.example.cursospring.entity.Curso;
import com.example.cursospring.entity.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Integer> {
    List<Inventario> findByTipo(String tipo);
    Inventario findByCodigo(Integer tipo);
    Inventario findFirstByCodigoOrNombre(Integer tipo,String nombre);
    List<Inventario> findAllByNombreContaining(String titulo);
}
