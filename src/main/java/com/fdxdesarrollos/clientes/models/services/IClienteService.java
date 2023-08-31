package com.fdxdesarrollos.clientes.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fdxdesarrollos.clientes.models.entity.Cliente;
import com.fdxdesarrollos.clientes.models.entity.Region;

public interface IClienteService {
	
	public List<Cliente> findAll();
	
	public Page<Cliente> findAll(Pageable pageable);
	
	public Cliente findById(Integer id);
	
	public Cliente save(Cliente cliente);
	
	public void delete(Integer id);
	
	public List<Region> findAllRegiones();

}
