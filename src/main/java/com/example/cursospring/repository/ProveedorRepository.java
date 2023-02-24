package com.example.cursospring.repository;

import com.example.cursospring.entity.Curso;
import com.example.cursospring.entity.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {
}
