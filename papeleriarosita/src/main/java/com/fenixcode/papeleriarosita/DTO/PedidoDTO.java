package com.fenixcode.papeleriarosita.DTO;

import java.time.LocalDateTime;

public class PedidoDTO {
   private int id_pedido;
	
	private int id_proveedor;
	private int id_producto;
	private int costo;
	private int cantidad;
	private LocalDateTime fecha_pedido_entrega;
	private boolean pedido_especial;
	
	public PedidoDTO() {
		
	}
	

	public PedidoDTO(int id_pedido, int id_proveedor, int id_producto, int costo, int cantidad,
			LocalDateTime fecha_pedido_entrega, boolean pedido_especial) {
		super();
		this.id_pedido = id_pedido;
		this.id_proveedor = id_proveedor;
		this.id_producto = id_producto;
		this.costo = costo;
		this.cantidad = cantidad;
		this.fecha_pedido_entrega = fecha_pedido_entrega;
		this.pedido_especial = pedido_especial;
	}


	public int getId_pedido() {
		return id_pedido;
	}


	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}


	public int getId_proveedor() {
		return id_proveedor;
	}


	public void setId_proveedor(int id_proveedor) {
		this.id_proveedor = id_proveedor;
	}


	public int getId_producto() {
		return id_producto;
	}


	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}


	public int getCosto() {
		return costo;
	}


	public void setCosto(int costo) {
		this.costo = costo;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public LocalDateTime getFecha_pedido_entrega() {
		return fecha_pedido_entrega;
	}


	public void setFecha_pedido_entrega(LocalDateTime fecha_pedido_entrega) {
		this.fecha_pedido_entrega = fecha_pedido_entrega;
	}


	public boolean isPedido_especial() {
		return pedido_especial;
	}


	public void setPedido_especial(boolean pedido_especial) {
		this.pedido_especial = pedido_especial;
	}


	
}
