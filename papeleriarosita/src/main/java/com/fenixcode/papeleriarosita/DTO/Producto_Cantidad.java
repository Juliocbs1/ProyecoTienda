package com.fenixcode.papeleriarosita.DTO;

public class Producto_Cantidad {

	private String nombre_producto;
	private int cantidad;

	public Producto_Cantidad() {

	}

	public Producto_Cantidad(String nombre_producto, int cantidad) {
		super();
		this.nombre_producto = nombre_producto;
		this.cantidad = cantidad;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
