package com.RubberDuck.demo.Controladores;

import java.util.List;

import javax.validation.Valid;

import com.RubberDuck.demo.Entidades.Tecnico;
import com.RubberDuck.demo.Servicios.TecnicoServicio;

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
@RequestMapping("/v1/tecnico")
public class TecnicoController{
    @Autowired
    @Qualifier("serviciotecnico")
    TecnicoServicio servicio;

    @GetMapping("/obtener")
    public Tecnico obtenerTecnico(@RequestParam(name="id", required=true) long id){
        return servicio.obtenerporId(id);
    }

    @PostMapping("/agregar")
    public boolean agregarTecnico(@RequestBody @Valid Tecnico tecnico){
        return servicio.crear(tecnico);
    }

    @PutMapping("/actualizar")
    public boolean actualizarTecnico(@RequestBody @Valid Tecnico tecnico){
        return servicio.actualizar(tecnico);
    }

    @PutMapping("/actualizar_calificacion/{id}")
    public boolean actualizarCalificacion( @PathVariable("id") long id, @RequestParam(name="calificacion", required=true) int calificacion){
        Tecnico tecnico = servicio.obtenerporId(id);
        int calificacion_nueva = tecnico.getCalificacion() + calificacion;
        int cantidad_solicitudes_nueva = tecnico.getSolicitudes_finalizadas() + 1;
        tecnico.setCalificaion(calificacion_nueva);
        tecnico.setSolicitudes_finalizadas(cantidad_solicitudes_nueva);
        return servicio.actualizar(tecnico);
    }

    @DeleteMapping("/eliminar/{id}")
    public boolean borrarTecnico(@PathVariable("id") long id){
        return servicio.borrar(id);
    }

    @GetMapping("/getAll")
    public List<Tecnico> getAllTecnico(){
        return servicio.obtenerAll();
    }

}