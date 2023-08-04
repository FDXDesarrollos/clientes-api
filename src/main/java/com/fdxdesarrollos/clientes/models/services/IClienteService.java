package com.fdxdesarrollos.clientes.models.services;

import java.util.List;

import com.fdxdesarrollos.clientes.models.entity.Cliente;

public interface IClienteService {
	
	public List<Cliente> findAll();

}
