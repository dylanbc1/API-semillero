package com.autentication.apirest.services;

import com.autentication.apirest.model.Cliente;
import com.autentication.apirest.model.Factura;

import java.util.List;
import java.util.Optional;

public interface IClienteService {
    public Cliente createCliente(Cliente cliente);
    public Optional<Cliente> searchCliente(Long id);
    public List<Cliente> listClientes();
}
