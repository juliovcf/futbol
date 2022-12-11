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
@Table(name = "grupos")
public class Grupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinTable(name = "equipos")
    @JoinColumn(name = "id_equipo")
    private Equipo equipo;
    
    @Column(name = "grupo")
    private String nombreGrupo;

    @Column(name = "puntos")
    private int puntos;
   
    @Column(name = "goles_favor")
    private int golesFavor;

    @Column(name = "goles_contra")
    private int golesContra;

    public Grupo(Equipo equipo, String nombreGrupo) {
        this.equipo = equipo;
        this.nombreGrupo = nombreGrupo;
        this.puntos = 0;
        this.golesContra = 0;
        this.golesFavor = 0;
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
    
    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }
    
    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getGolesFavor() {
        return golesFavor;
    }

    public void setGolesFavor(int golesFavor) {
        this.golesFavor = golesFavor;
    }

    public int getGolesContra() {
        return golesContra;
    }

    public void setGolesContra(int golesContra) {
        this.golesContra = golesContra;
    }

    @Override
    public String toString() {
        return "Grupo [id=" + id + ", equipo=" + equipo + ", nombreGrupo=" + nombreGrupo + ", puntos=" + puntos
                + ", golesFavor=" + golesFavor + ", golesContra=" + golesContra + "]";
    }
    
}
