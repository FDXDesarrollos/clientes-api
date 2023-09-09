package com.fdxdesarrollos.clientes.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;


@Data
@Entity
@Table(name="usuarios")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;	
	
	@Column(unique=true, length=20)
	private String username;
	
	@Column(length=60)
	private String password;
	
	private Boolean enabled;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(name="usuarios_perfiles", 
    joinColumns=@JoinColumn(name="usuario_id"),
    inverseJoinColumns=@JoinColumn(name="perfil_id"),
    uniqueConstraints= {@UniqueConstraint(columnNames= {"usuario_id","perfil_id"})})
	private List<Perfil> perfiles;
	
	@Column(length=20)
	private String nombre;
	
	@Column(length=20)
	private String apellido;
	
	@Column(unique=true, length=20)
	private String email;
	
}