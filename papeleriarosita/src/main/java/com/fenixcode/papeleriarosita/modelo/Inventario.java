package com.fenixcode.papeleriarosita.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Inventario")
public class Inventario {
	@Id
	private int id_producto;
	private int cantidad;
	
	public Inventario() {
		// TODO Auto-generated constructor stub
	}

	public Inventario(int id_producto, int cantidad) {
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
