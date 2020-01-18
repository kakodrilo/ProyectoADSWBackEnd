package com.RubberDuck.demo.Entidades;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Table(name="solicitudes")
@Entity
public class Solicitud{
    @Id
    @GenericGenerator(name="incrementsolicitud", strategy="increment")
    @GeneratedValue(generator="incrementsolicitud")
    @Column(name="id_solicitud")
    long id;

    @Column(name="fecha")
    Date fecha;

    @Column(name="problema")
    String problema;

    @Column(name="categoria")
    String categoria;

    @Column(name="cliente")
    int cliente;

    @Column(name="asunto")
    String asunto;

    @Column(name="archivo")
    String archivo;

    @Column(name="tecnico")
    int tecnico;

    @Column(name="estado")
    int estado;

    
    public Solicitud(){
        
    }

    public Solicitud(long id, Date fecha, String problema, String categoria, int id_cliente, String asunto, String archivo,int id_tecnico,int estado) {
        this.id = id;
        this.fecha = fecha;
        this.problema = problema;
        this.categoria = categoria;
        this.cliente = id_cliente;
        this.asunto = asunto;
        this.archivo = archivo;
        this.tecnico = id_tecnico;
        this.estado = estado;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getProblema() {
        return this.problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public long getID_cliente() {
        return this.cliente;
    }

    public void setID_cliente(int id_cliente) {
        this.cliente = id_cliente;
    }

    public String getAsunto() {
        return this.asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getArchivo() {
        return this.archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public int getTecnico(){
        return this.tecnico;
    }

    public void setTecnico(int id_tecnico){
        this.tecnico = id_tecnico;
    }

    public int getEstado(){
        return this.estado;
    }

    public void setEstado(int estado){
        this.estado = estado;
    }


}