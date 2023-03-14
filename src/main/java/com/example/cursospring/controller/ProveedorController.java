package com.example.cursospring.controller;


import com.example.cursospring.entity.Cliente;
import com.example.cursospring.entity.Pedido_cliente;
import com.example.cursospring.entity.Proveedor;
import com.example.cursospring.service.PedidoClienteService;
import com.example.cursospring.service.ProveedorService;
import com.example.cursospring.service.ProveedorServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/proveedor")
@CrossOrigin(origins = {"*"})
public class ProveedorController {

    @Autowired
    private ProveedorServiceImp proveedorService;
    @GetMapping("/listarproveedor")
    public List<Proveedor> indext() {
        List<Proveedor> listaProveedores = proveedorService.findAll(); // obtiene la lista completa de proveedores
        List<Proveedor> listaProveedoresActivos = listaProveedores
                .stream() // convierte la lista en un flujo
                .filter(p ->p.isEstado()) // filtra solo los proveedores cuyo estado es true
                .collect(Collectors.toList()); // convierte el flujo filtrado en una lista
        return listaProveedoresActivos; // retorna la lista filtrada
    }


    @PostMapping("/crearproveedor")
    @ResponseStatus(HttpStatus.CREATED)
    public Proveedor save(@RequestBody Proveedor libro){
        return proveedorService.save(libro);
    }

    @GetMapping("/proveedorid/{id}")
    public Proveedor findById(@PathVariable Integer id){
        return proveedorService.findById(id);
    }


    @PutMapping("/eliminarproveedor")
    @ResponseStatus(HttpStatus.CREATED)
    public String delete(@RequestParam("id") int id) {
        Proveedor p=proveedorService.findById(id);
        if(p.isEstado()==true){
            p.setEstado(false);
        }else{
            p.setEstado(true);
        }
        proveedorService.save(p);
        return "Id: "+ id+ " Eliminado correctamente";
    }

    @PutMapping("/editarproveedor/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Proveedor editar(@RequestBody Proveedor proveedor, @PathVariable Integer id){
        Proveedor proveedoractual=proveedorService.findById(id);
        proveedoractual.setNombre_comercial(proveedor.getNombre_comercial());
        proveedoractual.setPersona(proveedor.getPersona());
        proveedoractual.setCelular(proveedor.getCelular());


        return proveedorService.save(proveedoractual);
    }

    @GetMapping("/proveedorced/{ced}")
    public Optional<Proveedor> proveedorcedula(@PathVariable String ced) {
        return proveedorService.buscarporcedula(ced);
    }
}
