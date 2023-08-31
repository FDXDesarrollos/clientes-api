package com.fdxdesarrollos.clientes.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fdxdesarrollos.clientes.models.entity.Cliente;
import com.fdxdesarrollos.clientes.models.entity.Region;

public interface IClienteDao extends JpaRepository<Cliente, Integer> {
	
	@Query("from Region")
	public List<Region> findAllRegiones();
}
