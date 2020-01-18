package com.RubberDuck.demo.Entidades;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Table(name="clientes")
@Entity
public class Cliente{
    @Id
    @GenericGenerator(name="incrementcliente", strategy="increment")
    @GeneratedValue(generator="incrementcliente")
    @Column(name="id_cliente")
    long id;
    
    @Column(name="nombre")
    String nombre;

    @Column(name="correo")
    String correo;

    @Column(name="contraseña")
    String contraseña;

    /*@OneToMany(mappedBy = "equipo")
    private Set<Jugador> jugadores;
    */

    /*
    public Cliente(){

    }
    */
    public Cliente() {

    }
    public Cliente(long id, String nombre, String correo, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
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

}