package com.autentication.apirest.services.impl;

import com.autentication.apirest.model.Cliente;
import com.autentication.apirest.model.Detalle;
import com.autentication.apirest.model.Factura;
import com.autentication.apirest.repository.IFacturaRepository;
import com.autentication.apirest.services.IClienteService;
import com.autentication.apirest.services.IDetalleService;
import com.autentication.apirest.services.IFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FacturaServiceImpl implements IFacturaService {
    IFacturaRepository iFacturaRepository;
    private IClienteService iClienteService;
    private IDetalleService iDetalleService;

    @Autowired
    public FacturaServiceImpl(IFacturaRepository facturaRepository, IClienteService iClienteService, IDetalleService iDetalleService) {
        this.iFacturaRepository = facturaRepository;
        this.iClienteService = iClienteService;
        this.iDetalleService = iDetalleService;
    }

    @Override
    public Factura createFactura(Factura factura) {
        return iFacturaRepository.save(factura);
    }

    @Override
    public Cliente getCliente(Long id_factura) {
        return iFacturaRepository.findById(id_factura).get().getId_cliente();
    }

    @Override
    public List<Factura> getFacturasFromClient(Long id_client) {
        List<Factura> facturasRepo = listFacturas();
        List<Factura> facturasFromClient = new ArrayList<>();

        for (int i = 0; i < facturasRepo.size(); i++) {
            if (facturasRepo.get(i).getId_cliente().getId_cliente().equals(id_client)) {
                facturasFromClient.add(facturasRepo.get(i));
            }
        }

        return facturasFromClient;
    }

    @Override
    public double getValueOfFactura(Factura factura) {
        double value = 0;

        List<Detalle> detallesFromFactura = getDetalles(factura.getNum_factura());

        for (int i = 0; i < detallesFromFactura.size(); i++) {
            value += detallesFromFactura.get(i).getPrecio();
        }

        return value;
    }

    @Override
    public int itemsFromFactura(Factura factura) {
        int items = 0;

        List<Detalle> detallesFromFactura = getDetalles(factura.getNum_factura());

        for (int i = 0; i < detallesFromFactura.size(); i++) {
            items += detallesFromFactura.get(i).getCantidad();
        }

        return items;
    }

    @Override
    public List<Detalle> getDetalles(Long id_factura) {
        List<Detalle> detalles = new ArrayList<>();
        List<Detalle> detallesRepo = iDetalleService.listDetalles();

        for (int i = 0; i < detallesRepo.size(); i++) {
            if (detallesRepo.get(i).getId_factura().getNum_factura().equals(id_factura)){
                detalles.add(detallesRepo.get(i));
            }
        }

        return detalles;
    }

    @Override
    public Optional<Factura> searchFactura(Long id) {
        return iFacturaRepository.findById(id);
    }

    @Override
    public List<Factura> listFacturas() {
        return iFacturaRepository.findAll();
    }
}
