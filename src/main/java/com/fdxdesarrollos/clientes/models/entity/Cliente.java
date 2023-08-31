package com.fdxdesarrollos.clientes.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


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
	
	@NotNull(message = "No puede estar vacio")
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@Lob()	//	Long Byte
	@Basic(fetch = FetchType.LAZY)	//	Lazy loading (Carga demorada): Los objetos de carga demorada no serán cargados desde la base de datos cuando el objeto sea creado, pero será cargado en cuanto se acceda a la propiedad
	@Column(name="imagen", length = 1000)
	private byte[] imagen;
	
	@ManyToOne(fetch=FetchType.LAZY)	// @ManyToOne por que muchos clientes tienen una region
	@JoinColumn(name="region_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@NotNull(message = "Debe seleccionar una región")
	private Region region;
	
	/*@PrePersist
	public void prePersist() {
		fecha = new Date();
	}*/
	
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
	
	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte imagen[]) {
		this.imagen = imagen;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", fecha=" + fecha + "]";
	}

}
