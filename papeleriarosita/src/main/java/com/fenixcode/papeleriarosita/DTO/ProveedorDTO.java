package com.fenixcode.papeleriarosita.DTO;


public class ProveedorDTO {
	
	
	private long id_proveedor;
	private String nom_proveedor;
	private long telefono;
	
	public ProveedorDTO() {
		
	}

	public ProveedorDTO(long id_proveedor, String nom_proveedor, long telefono) {
		
		this.id_proveedor = id_proveedor;
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
