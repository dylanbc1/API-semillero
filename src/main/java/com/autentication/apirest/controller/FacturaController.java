package com.autentication.apirest.controller;

import com.autentication.apirest.model.Cliente;
import com.autentication.apirest.model.Factura;
import com.autentication.apirest.services.IClienteService;
import com.autentication.apirest.services.IFacturaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facturas")
public class FacturaController {

    private IFacturaService facturaService;

    public FacturaController(IFacturaService facturaService) {
        this.facturaService = facturaService;
    }

    @GetMapping("/client/{client_id}")
    public ResponseEntity<List<Factura>> getFacturasFromClient(@PathVariable Long client_id){
        return new ResponseEntity<>(this.facturaService.getFacturasFromClient(client_id), HttpStatus.OK);
    }

    @GetMapping("/client/{client_id}/{factura_id}")
    public ResponseEntity<Factura> getFacturaFromClient(@PathVariable Long client_id, @PathVariable Long factura_id){
        List<Factura> facturas = this.facturaService.getFacturasFromClient(client_id);

        for (int i = 0; i < facturas.size(); i++) {
            if (facturas.get(i).getNum_factura().equals(factura_id)){
                if (this.facturaService.getValueOfFactura(facturas.get(i)) > 1000000 &&
                        this.facturaService.itemsFromFactura(facturas.get(i)) >= 5){
                    return new ResponseEntity<>(facturas.get(i), HttpStatus.OK);
                } else {
                    return new ResponseEntity<>(facturas.get(i), HttpStatus.OK);
                }
            }
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Factura> createFactura(@RequestBody Factura factura) {
        Factura newClient = this.facturaService.createFactura(factura);

        if (newClient != null) {
            return new ResponseEntity<>(newClient, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
