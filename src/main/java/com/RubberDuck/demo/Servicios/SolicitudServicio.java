package com.RubberDuck.demo.Servicios;

import java.util.List;

import com.RubberDuck.demo.Entidades.Solicitud;
import com.RubberDuck.demo.Repositorios.SolicitudRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("serviciosolicitud")
public class SolicitudServicio{

    @Autowired
    @Qualifier("repositoriosolicitud")
    private SolicitudRepositorio repositorio;
    
    public boolean crear(Solicitud solicitud){
        try{
            repositorio.save(solicitud);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean actualizar(Solicitud solicitud){
        try{
            repositorio.save(solicitud);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean borrar(long id){
        try{
            Solicitud solicitud = repositorio.findById(id);
            repositorio.delete(solicitud);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public Solicitud obtenerporId(long id){
        return repositorio.findById(id);
    }

    public List<Solicitud> obtenerByCategoria(String categoria){
        return repositorio.findByCategoria(categoria);
    }

    public List<Solicitud> obtenerporEstado(int estado){
        return repositorio.findByEstado(estado);
    }

    
    public List<Solicitud> obtenerporEstadoTecnico(int estado, int tecnico){
        return repositorio.findByEstadoAndTecnico(estado,tecnico);
    }

    public List<Solicitud> obtenerporEstadoCliente(int estado, int cliente){
        return repositorio.findByEstadoAndCliente(estado, cliente);
    }
    
}