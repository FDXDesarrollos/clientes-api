package com.fdxdesarrollos.clientes.models.services;

import com.fdxdesarrollos.clientes.models.entity.Usuario;

public interface IUsuarioService {
	public Usuario findByusername(String username);
}
