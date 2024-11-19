package com.fenixcode.papeleriarosita.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Proveedor")
public class Proveedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_proveedor;
	private String nom_proveedor;
	private long telefono;
	
	
	public Proveedor() {
		// TODO Auto-generated constructor stub
	}


	public Proveedor(String nom_proveedor, long telefono) {
		super();
		this.nom_proveedor = nom_proveedor;
		this.telefono = telefono;
	}


	public long getId_proveedor() {
		return id_proveedor;
	}


	public void setId_proveedor(long id_proveedor) {
		this.id_proveedor = id_proveedor;
	}


	public String getNom_proveedor() {
		return nom_proveedor;
	}


	public void setNom_proveedor(String nom_proveedor) {
		this.nom_proveedor = nom_proveedor;
	}


	public long getTelefono() {
		return telefono;
	}


	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}
	
}
