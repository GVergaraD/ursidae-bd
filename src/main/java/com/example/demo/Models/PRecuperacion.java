package com.example.demo.Models;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name= "precuperacion")
public class PRecuperacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "cargo")
    private String cargo;

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    @ManyToMany(mappedBy = "precuperacions")
    private Set<SalaR> salasR;
}
