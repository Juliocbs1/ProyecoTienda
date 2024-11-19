package com.fenixcode.papeleriarosita.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="PRODUCTO_COMPRADO")
public class ProductoComprado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID_PRODUCTO_COMPRADO;
	private int ID_VENTA;
	private int ID_PRODUCTO;
	private int CANTIDAD_PRODUCTO;
	
	
	public ProductoComprado() {
		// TODO Auto-generated constructor stub
	}


	public ProductoComprado(int iD_VENTA, int iD_PRODUCTO, int cANTIDAD_PRODUCTO) {
		super();
		ID_VENTA = iD_VENTA;
		ID_PRODUCTO = iD_PRODUCTO;
		CANTIDAD_PRODUCTO = cANTIDAD_PRODUCTO;
	}


	public int getID_PRODUCTO_COMPRADO() {
		return ID_PRODUCTO_COMPRADO;
	}


	public void setID_PRODUCTO_COMPRADO(int iD_PRODUCTO_COMPRADO) {
		ID_PRODUCTO_COMPRADO = iD_PRODUCTO_COMPRADO;
	}


	public int getID_VENTA() {
		return ID_VENTA;
	}


	public void setID_VENTA(int iD_VENTA) {
		ID_VENTA = iD_VENTA;
	}


	public int getID_PRODUCTO() {
		return ID_PRODUCTO;
	}


	public void setID_PRODUCTO(int iD_PRODUCTO) {
		ID_PRODUCTO = iD_PRODUCTO;
	}


	public int getCANTIDAD_PRODUCTO() {
		return CANTIDAD_PRODUCTO;
	}


	public void setCANTIDAD_PRODUCTO(int cANTIDAD_PRODUCTO) {
		CANTIDAD_PRODUCTO = cANTIDAD_PRODUCTO;
	}
	
	
	
}
