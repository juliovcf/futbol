package com.torneo.futbol.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "jugadores")
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinTable(name = "equipos")
    @JoinColumn(name = "id_equipo")
    private Equipo equipo;
    
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "posicion")
    private String posicion;

    @Column(name = "dorsal")
    private Integer dorsal;

    @Column(name = "calidad")
    private Integer calidad;

    @Column(name = "goles")
    private Integer goles;

    @Column(name = "amarillas")
    private Integer amarillas;

    @Column(name = "rojas")
    private Integer rojas;

    public Jugador(Equipo equipo, String nombre, String posicion, Integer dorsal, Integer calidad) {
        this.equipo = equipo;
        this.nombre = nombre;
        this.posicion = posicion;
        this.dorsal = dorsal;
        this.calidad = calidad;
        this.goles = 0;
        this.amarillas = 0;
        this.rojas = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public Integer getDorsal() {
        return dorsal;
    }

    public void setDorsal(Integer dorsal) {
        this.dorsal = dorsal;
    }

    public Integer getCalidad() {
        return calidad;
    }

    public void setCalidad(Integer calidad) {
        this.calidad = calidad;
    }

    public Integer getGoles() {
        return goles;
    }

    public void setGoles(Integer goles) {
        this.goles = goles;
    }

    public Integer getAmarillas() {
        return amarillas;
    }

    public void setAmarillas(Integer amarillas) {
        this.amarillas = amarillas;
    }

    public Integer getRojas() {
        return rojas;
    }

    public void setRojas(Integer rojas) {
        this.rojas = rojas;
    }

    @Override
    public String toString() {
        return "Jugador [id=" + id + ", equipo=" + equipo + ", nombre=" + nombre + ", posicion=" + posicion
                + ", dorsal=" + dorsal + ", calidad=" + calidad + ", goles=" + goles + ", amarillas=" + amarillas
                + ", rojas=" + rojas + "]";
    }
}
