package com.RubberDuck.demo.Repositorios;

import java.io.Serializable;
import java.util.List;

import com.RubberDuck.demo.Entidades.Tecnico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("repositoriotecnico")
public interface TecnicoRepositorio extends JpaRepository<Tecnico, Serializable>{
    
    public abstract Tecnico findById(long id);

    public abstract List<Tecnico> findAll();

}