package com.RubberDuck.demo.Repositorios;

import java.io.Serializable;
import java.util.List;

import com.RubberDuck.demo.Entidades.Mensaje;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("repositoriomensaje")
public interface MensajeRepositorio extends JpaRepository<Mensaje, Serializable>{
    
    public abstract Mensaje findById(long id);

    public abstract List<Mensaje> findAll();

    public abstract List<Mensaje> findBySolicitudOrderByHoraAsc(int solicitud);

    public abstract List<Mensaje> findBySolicitudAndIdGreaterThanOrderByHoraAsc(int solicitud, int id);

}