package com.fdxdesarrollos.clientes.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.fdxdesarrollos.clientes.models.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Integer>{
	
	public Usuario findByusername(String username);
	
	@Query("select u from Usuario u where u.username=?1")
	public Usuario buscaUsuario(String username);
}
