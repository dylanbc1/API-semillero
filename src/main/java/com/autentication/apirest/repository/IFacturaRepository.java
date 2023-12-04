package com.autentication.apirest.repository;

import com.autentication.apirest.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacturaRepository extends JpaRepository<Factura,Long> {
}
