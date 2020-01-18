package com.RubberDuck.demo.Entidades;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Table(name="mensajes")
@Entity
public class Mensaje{
    @Id
    @GenericGenerator(name="incrementmensaje", strategy="increment")
    @GeneratedValue(generator="incrementmensaje")
    @Column(name="id_mensaje")
    int id;
    
    @Column(name="emisor")
    int emisor;

    @Column(name="texto")
    String texto;

    @Column(name="solicitud")
    int solicitud;

    @Column(name="hora")
    Timestamp hora;

    public Mensaje() {

    }
    public Mensaje(int id, int emisor, String texto, int solicitud, Timestamp hora) {
        this.id = id;
        this.emisor = emisor;
        this.texto = texto;
        this.solicitud = solicitud;
        this.hora = hora;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmisor() {
        return this.emisor;
    }

    public void setEmisor(int emisor) {
        this.emisor = emisor;
    }

    public String getTexto() {
        return this.texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getSolicitud() {
        return this.solicitud;
    }

    public void setSolicitud(int solicitud) {
        this.solicitud = solicitud;
    }

    public Timestamp getHora() {
        return this.hora;
    }

    public void setHora(Timestamp hora) {
        this.hora = hora;
    }
}