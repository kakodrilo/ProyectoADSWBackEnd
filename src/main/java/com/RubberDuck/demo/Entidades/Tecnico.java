package com.RubberDuck.demo.Entidades;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Table(name="tecnicos")
@Entity
public class Tecnico{
    @Id
    @GenericGenerator(name="incrementtecnico", strategy="increment")
    @GeneratedValue(generator="incrementtecnico")
    @Column(name="id_tecnico")
    long id;
    
    @Column(name="nombre")
    String nombre;

    @Column(name="correo")
    String correo;

    @Column(name="contraseña")
    String contraseña;

    @Column(name="calificacion")
    int calificacion;

    @Column(name="solicitudes_finalizadas")
    int solicitudes_finalizadas;

    
    public Tecnico() {

    }
    public Tecnico(long id, String nombre, String correo, String contraseña,int calificacion,int solicitudes_finalizadas) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.calificacion = calificacion;
        this.solicitudes_finalizadas = solicitudes_finalizadas;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return this.contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getCalificacion(){
        return this.calificacion;
    }

    public void setCalificaion(int calificacion){
        this.calificacion = calificacion;
    }

    public int getSolicitudes_finalizadas(){
        return this.solicitudes_finalizadas;
    }

    public void setSolicitudes_finalizadas( int solicitudes_finalizadas){
        this.solicitudes_finalizadas = solicitudes_finalizadas;
    }

}