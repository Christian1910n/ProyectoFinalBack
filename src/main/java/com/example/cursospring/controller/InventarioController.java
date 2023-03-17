package com.example.cursospring.controller;

import com.example.cursospring.entity.Curso;
import com.example.cursospring.entity.Inventario;
import com.example.cursospring.entity.Proveedor;
import com.example.cursospring.repository.CursoRepository;
import com.example.cursospring.repository.InventarioRepository;
import com.example.cursospring.service.CursoService;
import com.example.cursospring.service.CursoServiceImp;
import com.example.cursospring.service.InventarioService;
import com.example.cursospring.service.InventarioServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/inventario")
@CrossOrigin(origins = {"*"})
public class InventarioController {
//Implementamos

    @Autowired
    private InventarioRepository inventarioRepository;

    @Autowired
    private InventarioServiceImp  s3service;

    private InventarioService inventarioService;

    //Listar
    @GetMapping("/listarinventario")
    List<Inventario> getAll(){
        return  inventarioRepository.findAll();
    }

    //Crear
    @PostMapping("/crearinventario")
    @ResponseStatus(HttpStatus.CREATED)
    Inventario create(@RequestBody Inventario inventario){
        inventarioRepository.save(inventario);
        return inventario;
    }

    //


    @PutMapping("/editarinventario/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Inventario editar(@RequestBody Inventario inventario, @PathVariable Integer id){
        Inventario inventarioActual=inventarioService.findById(id);
        inventarioActual.setDescripcion(inventario.getDescripcion());
        inventarioActual.setCantidad(inventario.getCantidad());
        inventarioActual.setValor(inventario.getValor());
        inventarioActual.setFecha_caducidad(inventario.getFecha_caducidad());
        inventarioActual.setTipo(inventario.getTipo());
        inventarioActual.setImagen(inventario.getImagen());
        
        return inventarioService.save(inventarioActual);
    }

    @GetMapping("/tipo/{usuario}")
    public List<Inventario> findByTipo(@PathVariable String usuario){
        return inventarioRepository.findByTipo(usuario);
    }

    @GetMapping("/producto/{codigo}")
    public Inventario findBy(@PathVariable String codigo){
        Integer codigoInt;
        System.out.println(codigo);
        try {
            codigoInt = Integer.parseInt(codigo);
            System.out.println("Buscar por codigo");
            return inventarioRepository.findFirstByCodigoOrNombre(codigoInt, null);

        } catch (NumberFormatException e) {
            System.out.println("Buscar por nombre");
            return inventarioRepository.findFirstByCodigoOrNombre(null, codigo);
        }
    }


    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
    @PutMapping("/editarcantidad")
    @ResponseStatus(HttpStatus.CREATED)
    public Inventario editarcantidad(@RequestParam("id") Integer id, @RequestParam("cantidad")Integer cantidad){
        Inventario inventarioActual=inventarioRepository.findByCodigo(id);

        inventarioActual.setCantidad(inventarioActual.getCantidad()-cantidad);

        return s3service.save(inventarioActual);
    }

    @GetMapping("/nombre/{titulo}")
    public List<Inventario> inventariosxnombre(@PathVariable String titulo){
        return s3service.findAllByNombreLike(titulo);
    }

}
