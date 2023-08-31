package com.fdxdesarrollos.clientes.controllers;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fdxdesarrollos.clientes.models.entity.Cliente;
import com.fdxdesarrollos.clientes.models.entity.Region;
import com.fdxdesarrollos.clientes.models.services.IClienteService;
import com.fdxdesarrollos.clientes.utils.Util;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ClienteRestController {
	
	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("/clientes")
	public List<Cliente> index(){
		return clienteService.findAll();
	}

	@GetMapping("/clientes/page/{page}")
	public Page<Cliente> index(@PathVariable Integer page){
		Pageable pageable = PageRequest.of(page, 5);
		return clienteService.findAll(pageable);
	}	
	
	@GetMapping("/clientes/{id}")
	public ResponseEntity<?> show(@PathVariable Integer id) {
		Cliente cliente = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			cliente = clienteService.findById( id );
			
			if(cliente == null) {
				response.put("mensaje", "El cliente ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}						
		} catch( DataAccessException ex ) {
			response.put("mensaje", "Error al consultar la base de datos");
			response.put("error", ex.getMessage().concat(": ").concat(ex.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}
	
	@PostMapping("/clientes")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@Valid @RequestBody Cliente cliente, BindingResult result) {
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {
			/* Obtener lista de errores antes de Java 8 */
			/*List<String> errors = new ArrayList<>();
			
			for(FieldError err: result.getFieldErrors()) {
				errors.add("El campo: '" + err.getField() + "' " + err.getDefaultMessage() );
			}*/
			
			/* Obtener lista de errores con Java 8 */
			List<String> errors = result.getFieldErrors()
					.stream()
					.map( (err) -> "El campo: '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			cliente = clienteService.save(cliente);
		} catch( DataAccessException ex ) {
			response.put("mensaje", "Error al realizar insert en base de datos");
			response.put("error", ex.getMessage().concat(": ").concat(ex.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "Información registrada correctamente");
		response.put("cliente", cliente);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);		
	}
	
	@PutMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> update(@Valid @RequestBody Cliente nvo, BindingResult result, @PathVariable Integer id) {
		Map<String, Object> response = new HashMap<>();
		Cliente cliente = null;
		
		if(result.hasErrors()) {
			/* Obtener lista de errores con Java 8 */
			List<String> errors = result.getFieldErrors()
					.stream()
					.map( err -> "El campo: '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}	
		
		cliente = clienteService.findById(id);
		
		if(cliente == null) {
			response.put("mensaje", "Error: no se logro editar, el cliente ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}		
		
		try {
			cliente.setNombre(nvo.getNombre());
			cliente.setApellido(nvo.getApellido());
			cliente.setCorreo(nvo.getCorreo());
			cliente.setFecha(nvo.getFecha());
			cliente.setRegion(nvo.getRegion());
			
			cliente = clienteService.save(cliente);
			
		} catch( DataAccessException ex ) {
			response.put("mensaje", "Error al realizar update en base de datos");
			response.put("error", ex.getMessage().concat(": ").concat(ex.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		
		response.put("mensaje", "Información actualizada correctamente");
		response.put("cliente", cliente);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);			
	}
	
	@DeleteMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		Map<String, Object> response = new HashMap<>();	
		
		try {
			clienteService.delete(id);
		} catch( DataAccessException ex ) {
			response.put("mensaje", "Error al realizar delete en base de datos");
			response.put("error", ex.getMessage().concat(": ").concat(ex.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}		
		
		response.put("mensaje", "Información eliminada correctamente");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);			
	}
	
	@PostMapping("/clientes/upload")
	@ResponseStatus(HttpStatus.CREATED)	
	public ResponseEntity<?> upload(@RequestParam("id") Integer id, @RequestParam("imagen") MultipartFile imagen){
		Cliente cliente = null;
		Map<String, Object> response = new HashMap<>();
		
		if(!imagen.isEmpty()) {
			String nombreArchivo = imagen.getOriginalFilename();
			Path rutaArchivo = Paths.get("uploads").resolve(nombreArchivo).toAbsolutePath();

			//UUID.randomUUID().toString()
			
			if(imagen.getSize() > (1024*1024)) {
				response.put("mensaje", "Error al subir la imagen: " + nombreArchivo);
				response.put("error", "La imagen debe ser menor a 1MB");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);						
			}
			
			try {
				cliente = clienteService.findById(id);
				cliente.setImagen( Util.compressZLib(imagen.getBytes()) );
				clienteService.save(cliente);
				
				cliente.setImagen( imagen.getBytes() );
			} catch (IOException | DataAccessException ex) {
				ex.printStackTrace();
				response.put("mensaje", "Error al subir la imagen: " + nombreArchivo);
				response.put("error", ex.getMessage().concat(": ").concat(ex.getCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);				
			}
			
			response.put("cliente", cliente);
			response.put("mensaje", "Imagen: " + nombreArchivo + ", enviada correctamente");
		}
		
		/*try {
			
		} catch( DataAccessException ex ) {
			response.put("mensaje", "Error al registrar imagen en base de datos");
			response.put("error", ex.getMessage().concat(": ").concat(ex.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}*/				
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/clientes/regiones")
	public List<Region> listarRegiones(){
		return clienteService.findAllRegiones();
	}

}
