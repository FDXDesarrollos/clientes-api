package com.fdxdesarrollos.clientes.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.fdxdesarrollos.clientes.models.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Integer> {

}
