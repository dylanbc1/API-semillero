package com.autentication.apirest.services;

import com.autentication.apirest.model.Cliente;
import com.autentication.apirest.model.Detalle;
import com.autentication.apirest.model.Factura;

import java.util.List;
import java.util.Optional;

public interface IFacturaService {
    public Factura createFactura(Factura factura);
    public Cliente getCliente(Long id_factura);
    public List<Factura> getFacturasFromClient(Long id_client);
    public List<Detalle> getDetalles(Long id_factura);
    public Optional<Factura> searchFactura(Long id);
    public List<Factura> listFacturas();
    public double getValueOfFactura(Factura factura);
    public int itemsFromFactura(Factura factura);
}
