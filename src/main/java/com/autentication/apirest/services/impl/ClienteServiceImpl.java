package com.autentication.apirest.services.impl;

import com.autentication.apirest.model.Cliente;
import com.autentication.apirest.repository.IClienteRepository;
import com.autentication.apirest.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements IClienteService {
    IClienteRepository clienteRepository;

    @Autowired
    public ClienteServiceImpl(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Optional<Cliente> searchCliente(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public List<Cliente> listClientes() {
        return clienteRepository.findAll();
    }
}
