package com.fenixcode.papeleriarosita.DTO;



public class InventarioDTO {

	private int id_producto;
	private int cantidad;
	
	public InventarioDTO() {
		
	}

	public InventarioDTO(int id_producto, int cantidad) {
		super();
		this.id_producto = id_producto;
		this.cantidad = cantidad;
	}

	public int getId_producto() {
		return id_producto;
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
