package com.autentication.apirest.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;


@Entity(name = "Cliente")
@Table(name = "CLIENTE")
@Data
@AllArgsConstructor
public class Cliente {
    @Id
    @SequenceGenerator(
            name="cliente_sequence",
            sequenceName = "cliente_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = SEQUENCE, generator = "cliente_sequence")
    private Long id_cliente;
    private String nombre;
    private String apellido;
    private String direccion;
    private Date fecha_nacimiento;
    private String email;
    private String categoria;

    public Cliente() {

    }
}
