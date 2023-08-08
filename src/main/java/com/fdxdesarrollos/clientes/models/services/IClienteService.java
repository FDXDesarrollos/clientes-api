package com.fdxdesarrollos.clientes.models.services;

import java.util.List;

import com.fdxdesarrollos.clientes.models.entity.Cliente;

public interface IClienteService {
	
	public List<Cliente> findAll();
	
	public Cliente findById(Integer id);
	
	public Cliente save(Cliente cliente);
	
	public void delete(Integer id);

}
