package com.RubberDuck.demo.Controladores;

import java.util.List;

import javax.validation.Valid;

import com.RubberDuck.demo.Entidades.Mensaje;
import com.RubberDuck.demo.Servicios.MensajeServicio;

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
@RequestMapping("/v1/mensaje")
public class MensajeController{
    @Autowired
    @Qualifier("serviciomensaje")
    MensajeServicio servicio;

    @GetMapping("/obtener_id")
    public Mensaje obtenerMensaje(@RequestParam(name="id", required=true) int id){
        return servicio.obtenerporId(id);
    }

    @PostMapping("/agregar")
    public boolean agregarMensaje(@RequestBody @Valid Mensaje mensaje){
        return servicio.crear(mensaje);
    }

    @PutMapping("/actualizar")
    public boolean actualizarMensaje(@RequestBody @Valid Mensaje mensaje){
        return servicio.actualizar(mensaje);
    }

    @DeleteMapping("/eliminar/{id}")
    public boolean borrarMensaje(@PathVariable("id") int id){
        return servicio.borrar(id);
    }

    @GetMapping("/getAll")
    public List<Mensaje> getAllMensaje(){
        return servicio.obtenerAll();
    }

    @GetMapping("/getChat")
    public List<Mensaje> getChat(@RequestParam(name="solicitud", required=true) int solicitud){
        return servicio.obtenerChat(solicitud);
    }

    @GetMapping("/updateChat")
    public List<Mensaje> updateChat(@RequestParam(name="solicitud", required=true) int solicitud, @RequestParam(name="id", required=true) int id){
        return servicio.updateChat(solicitud, id);
    }
}