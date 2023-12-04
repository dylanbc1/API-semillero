package com.autentication.apirest.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;


@Entity(name = "Producto")
@Table(name = "PRODUCTO")
@Data
@AllArgsConstructor
public class Producto {
    @Id
    @SequenceGenerator(
            name="producto_sequence",
            sequenceName = "producto_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = SEQUENCE, generator = "producto_sequence")
    private Long id_producto;
    private String nombre;
    private double precio;
    private int stock;

    public Producto() {

    }
}
