package com.autentication.apirest.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;


@Entity(name = "Factura")
@Table(name = "FACTURA")
@Data
@AllArgsConstructor
public class Factura {
    @Id
    @SequenceGenerator(
            name="factura_sequence",
            sequenceName = "factura_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = SEQUENCE, generator = "factura_sequence")
    private Long num_factura;
    // many to one, necesitamos instancia de ese ONE
    @ManyToOne
    private Cliente id_cliente;
    private Date fecha;

    public Factura() {

    }
}
