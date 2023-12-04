package com.autentication.apirest.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;


@Entity(name = "Detalle")
@Table(name = "DETALLE")
@Data
@AllArgsConstructor
public class Detalle {
    @Id
    @SequenceGenerator(
            name="detalle_sequence",
            sequenceName = "detalle_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = SEQUENCE, generator = "detalle_sequence")
    private Long num_detalle;
    // many to one, necesitamos instancia de ese ONE
    @ManyToOne
    private Factura id_factura;
    @ManyToOne
    private Producto id_producto;
    private int cantidad;
    private double precio;

    public Detalle() {

    }
}
