package com.autentication.apirest.services.impl;

import com.autentication.apirest.model.Producto;
import com.autentication.apirest.repository.IProductoRepository;
import com.autentication.apirest.services.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements IProductoService {
    IProductoRepository iProductoRepository;

    @Autowired
    public ProductoServiceImpl(IProductoRepository iProductoRepository) {
        this.iProductoRepository = iProductoRepository;
    }

    @Override
    public List<Producto> listProductos() {
        return iProductoRepository.findAll();
    }
}
