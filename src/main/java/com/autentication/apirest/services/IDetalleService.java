package com.autentication.apirest.services;

import com.autentication.apirest.model.Detalle;
import com.autentication.apirest.model.Factura;
import com.autentication.apirest.model.Producto;

import java.util.List;
import java.util.Optional;

public interface IDetalleService {
    public Detalle createDetalle(Detalle cliente);
    public Optional<Detalle> searchDetalle(Long id);
    public List<Producto> getProductos();
    public List<Detalle> listDetalles();
}
