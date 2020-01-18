package com.RubberDuck.demo.Repositorios;

import java.io.Serializable;
import java.util.List;

import com.RubberDuck.demo.Entidades.Solicitud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("repositoriosolicitud")
public interface SolicitudRepositorio extends JpaRepository<Solicitud, Serializable> {

    public abstract Solicitud findById(long id);

    public abstract List<Solicitud> findByCategoria(String categoria);

    public abstract List<Solicitud> findByEstado(int estado);

    public abstract List<Solicitud> findByEstadoAndTecnico(int estado, int tecnico);

    public abstract List<Solicitud> findByEstadoAndCliente(int estado, int cliente);

}