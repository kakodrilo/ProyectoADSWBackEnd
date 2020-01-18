package com.RubberDuck.demo.Controladores;

import java.util.List;

import javax.validation.Valid;

import com.RubberDuck.demo.Entidades.Solicitud;
import com.RubberDuck.demo.Servicios.SolicitudServicio;

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
@RequestMapping("/v1/solicitud")
public class SolicitudController{
    @Autowired
    @Qualifier("serviciosolicitud")
    SolicitudServicio servicio;

    @GetMapping("/obtener_id")
    public Solicitud obtenerSolicitud(@RequestParam(name="id", required=true) long id){
        return servicio.obtenerporId(id);
    }

    @GetMapping("/obtener_estado")
    public List<Solicitud> obtenerSolicitudEstado(@RequestParam(name="estado", required=true) int estado){
        return servicio.obtenerporEstado(estado);
    }

    
    @GetMapping("/obtener_estado_tecnico")
    public List<Solicitud> obtenerSolicitudEstadoTecnico(@RequestParam(name="estado", required=true) int estado,@RequestParam(name="tecnico", required=true) int tecnico){
        return servicio.obtenerporEstadoTecnico(estado,tecnico);
    }

    @GetMapping("/obtener_estado_cliente")
    public List<Solicitud> obtenerSolicitudEstadoCliente(@RequestParam(name="estado", required=true) int estado,@RequestParam(name="cliente", required=true) int cliente){
        return servicio.obtenerporEstadoCliente(estado,cliente);
    }
    

    @PostMapping("/agregar")
    public boolean agregarSolicitud(@RequestBody @Valid Solicitud solicitud){
        return servicio.crear(solicitud);
    }

    @PutMapping("/actualizar")
    public boolean actualizarSolicitud(@RequestBody @Valid Solicitud solicitud){
        return servicio.actualizar(solicitud);
    }

    @PutMapping("/cambiar_estado/{id}")
    public boolean actualizarEstado( @PathVariable("id") long id, @RequestParam(name="estado", required=true) int estado){
        Solicitud solicitud = servicio.obtenerporId(id);
        solicitud.setEstado(estado);
        return servicio.actualizar(solicitud);
    }

    @PutMapping("/cambiar_tecnico/{id}")
    public boolean actualizarTecnico( @PathVariable("id") long id, @RequestParam(name="tecnico", required=true) int tecnico){
        Solicitud solicitud = servicio.obtenerporId(id);
        solicitud.setTecnico(tecnico);
        return servicio.actualizar(solicitud);
    }

    @DeleteMapping("/eliminar/{id}")
    public boolean borrarSolicitud(@PathVariable("id") long id){
        return servicio.borrar(id);
    }

    @GetMapping("/categoria")
    public List<Solicitud> obtenerPorCategoria(@RequestParam(name="categoria", required = true) String categoria){
        return servicio.obtenerByCategoria(categoria);
    }

}