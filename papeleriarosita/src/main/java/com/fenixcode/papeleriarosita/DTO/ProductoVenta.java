package com.fenixcode.papeleriarosita.DTO;

public class ProductoVenta {
	
	private String nom_producto;
	private double precio_uni;
	private int cantidad;
	
	public ProductoVenta() {
		// TODO Auto-generated constructor stub
	}

	public ProductoVenta(String nom_producto, double precio_uni, int cantidad) {
		super();
		this.nom_producto = nom_producto;
		this.precio_uni = precio_uni;
		this.cantidad = cantidad;
	}

	public String getNom_producto() {
		return nom_producto;
	}

	public void setNom_producto(String nom_producto) {
		this.nom_producto = nom_producto;
	}

	public double getPrecio_uni() {
		return precio_uni;
	}

	public void setPrecio_uni(double precio_uni) {
		this.precio_uni = precio_uni;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	

}
