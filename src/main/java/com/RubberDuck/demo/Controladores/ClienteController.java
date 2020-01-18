package com.RubberDuck.demo.Controladores;

import java.util.List;

import javax.validation.Valid;

import com.RubberDuck.demo.Entidades.Cliente;
import com.RubberDuck.demo.Servicios.ClienteServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/cliente")
public class ClienteController{
    @Autowired
    @Qualifier("serviciocliente")
    ClienteServicio servicio;

    @GetMapping("/obtener")
    public Cliente obtenerCliente(@RequestParam(name="id", required=true) long id){
        return servicio.obtenerporId(id);
    }

    @PostMapping("/agregar")
    public boolean agregarCliente(@RequestBody @Valid Cliente cliente){
        return servicio.crear(cliente);
    }

    @PutMapping("/actualizar")
    public boolean actualizarCliente(@RequestBody @Valid Cliente cliente){
        return servicio.actualizar(cliente);
    }

    @DeleteMapping("/eliminar/{id}")
    public boolean borrarCliente(@PathVariable("id") long id){
        return servicio.borrar(id);
    }

    @GetMapping("/getAll")
    public List<Cliente> getAllCliente(){
        return servicio.obtenerAll();
    }

}