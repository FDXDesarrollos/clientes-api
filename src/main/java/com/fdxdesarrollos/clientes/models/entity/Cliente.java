package com.fdxdesarrollos.clientes.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name="clientes")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "No puede estar vacio")
	@Size(min=4, max=12, message = "El tamaño debe estar entre 4 y 12")
	@Column(nullable=false)
	private String nombre;
	
	@NotEmpty(message = "No puede estar vacio")
	private String apellido;
	
	@Email(message = "Formato de correo invalido")
	@NotEmpty(message = "No puede estar vacio")
	@Column(nullable=false, unique=true)
	private String correo;
	
	
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	@PrePersist
	public void prePersist() {
		fecha = new Date();
	}
	
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", fecha="
				+ fecha + "]";
	}

}
