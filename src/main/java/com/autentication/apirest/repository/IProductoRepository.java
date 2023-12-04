package com.autentication.apirest.repository;

import com.autentication.apirest.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepository extends JpaRepository<Producto,Long> {
}