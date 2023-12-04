package com.autentication.apirest.services.impl;

import com.autentication.apirest.model.Detalle;
import com.autentication.apirest.model.Factura;
import com.autentication.apirest.model.Producto;
import com.autentication.apirest.repository.IDetalleRepository;
import com.autentication.apirest.services.IDetalleService;
import com.autentication.apirest.services.IFacturaService;
import com.autentication.apirest.services.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleServiceImpl implements IDetalleService {

    IDetalleRepository detalleRepository;

    private IFacturaService iFacturaService;
    private IProductoService iProductoService;

    @Autowired
    public DetalleServiceImpl(IDetalleRepository detalleRepository, IFacturaService iFacturaService, IProductoService iProductoService) {
        this.detalleRepository = detalleRepository;
        this.iFacturaService = iFacturaService;
        this.iProductoService = iProductoService;
    }

    @Override
    public Detalle createDetalle(Detalle detalle) {
        return detalleRepository.save(detalle);
    }

    @Override
    public Optional<Detalle> searchDetalle(Long id) {
        return detalleRepository.findById(id);
    }

    @Override
    public List<Producto> getProductos() {
        return null;
    }

    @Override
    public List<Detalle> listDetalles() {
        return detalleRepository.findAll();
    }
}
