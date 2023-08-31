package com.fdxdesarrollos.clientes.models.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fdxdesarrollos.clientes.models.dao.IClienteDao;
import com.fdxdesarrollos.clientes.models.entity.Cliente;
import com.fdxdesarrollos.clientes.models.entity.Region;
import com.fdxdesarrollos.clientes.utils.Util;

@Service
public class ClienteServiceImp implements IClienteService {
	
	//@Autowired
	private IClienteDao clienteDao;

	public ClienteServiceImp(IClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteDao.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Cliente> findAll(Pageable pageable) {
		Page<Cliente> pagina = clienteDao.findAll(pageable);
		
		if(pagina.getSize() > 0) {
			pagina.stream().forEach( (c) -> {
				if(c.getImagen() != null) {
					byte[] imagen = Util.decompressZLib(c.getImagen());
					c.setImagen(imagen);
				}
			});
		}
		
		return pagina;
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Integer id) {
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		return clienteDao.save(cliente);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		clienteDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Region> findAllRegiones() {
		return clienteDao.findAllRegiones();
	}

}
