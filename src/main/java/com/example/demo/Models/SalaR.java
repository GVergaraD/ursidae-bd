package com.example.demo.Models;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name= "salas")
public class SalaR {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "disponibilidad")
    private Integer disponibilidad;

    @Column(name = "capacidad")
    private Integer capacidad;

    public Long getId() {
        return id;
    }

    public Integer getDisponibilidad() {
        return disponibilidad;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDisponibilidad(Integer disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    @ManyToMany//(mappedBy = "salasR")
    private Set<PRecuperacion> precuperacions;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "salar_id")
    private List<Cama> camas = new ArrayList<>();

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "salar_id")
    private List<Paciente> pacientes = new ArrayList<>();

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }
}
