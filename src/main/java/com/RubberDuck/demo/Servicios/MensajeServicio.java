package com.RubberDuck.demo.Servicios;

import java.util.List;

import com.RubberDuck.demo.Entidades.Mensaje;
import com.RubberDuck.demo.Repositorios.MensajeRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("serviciomensaje")
public class MensajeServicio{

    @Autowired
    @Qualifier("repositoriomensaje")
    private MensajeRepositorio repositorio;

    public boolean crear(Mensaje mensaje){
        try{
            repositorio.save(mensaje);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean actualizar(Mensaje mensaje){
        try{
            repositorio.save(mensaje);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean borrar(int id){
        try{
            Mensaje mensaje = repositorio.findById(id);
            repositorio.delete(mensaje);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public Mensaje obtenerporId(int id){
        return repositorio.findById(id);
    }

    public List<Mensaje> obtenerAll(){
        return repositorio.findAll();
    }

    public List<Mensaje> obtenerChat(int solicitud){
        return repositorio.findBySolicitudOrderByHoraAsc(solicitud);
    }

    public List<Mensaje> updateChat(int solicitud, int id){
        return repositorio.findBySolicitudAndIdGreaterThanOrderByHoraAsc(solicitud, id);
    }
}