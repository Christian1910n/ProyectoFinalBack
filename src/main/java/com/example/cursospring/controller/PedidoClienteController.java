package com.example.cursospring.controller;


import com.example.cursospring.entity.Cliente;
import com.example.cursospring.entity.Pedido_cliente;
import com.example.cursospring.service.ClienteService;
import com.example.cursospring.service.PedidoClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidocliente")
@CrossOrigin(origins = {"*"})
public class PedidoClienteController {
    @Autowired
    private PedidoClienteService pedidoClienteService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/listarpedidocliente")
    public List<Pedido_cliente> indext(){
        return pedidoClienteService.findAll();
    }



    @PostMapping("/crearpedidocliente")
    public Pedido_cliente save(@RequestBody Pedido_cliente libro){

            System.out.println("Guardo esto");
            return pedidoClienteService.save(libro);


    }

    @GetMapping("/pedidocliente/{id}")
    public Pedido_cliente findById(@PathVariable Integer id){
        return pedidoClienteService.findById(id);
    }

    @DeleteMapping("/eliminarpedidocliente/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void eliminar(@PathVariable int id){
        pedidoClienteService.delete(id);
    }


}
