package com.fenixcode.papeleriarosita.DTO;



public class ProductoDTO {

	private int id_producto;
	private int id_proveedor;
	private String nom_producto;
	private double precio;
	
	public ProductoDTO() {
		
	}

	public ProductoDTO(int id_producto, int id_proveedor, String nom_producto, double precio) {
		
		this.id_producto = id_producto;
		this.id_proveedor = id_proveedor;
		this.nom_producto = nom_producto;
		this.precio = precio;
	}

	public int getId_producto() {
		return id_producto;
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}

	public int getId_proveedor() {
		return id_proveedor;
	}

	public void setId_proveedor(int id_proveedor) {
		this.id_proveedor = id_proveedor;
	}

	public String getNom_producto() {
		return nom_producto;
	}

	public void setNom_producto(String nom_producto) {
		this.nom_producto = nom_producto;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
}
