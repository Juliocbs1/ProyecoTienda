package com.fenixcode.papeleriarosita.DTO;

import java.time.LocalDateTime;

public class VentaDTO {

	private int id_venta;
	private long id_cliente;
	private int total;
	private int cambio;
	private LocalDateTime fecha;

	public VentaDTO() {

	}

	public VentaDTO(long id_cliente, int total, int cambio) {

		this.id_cliente = id_cliente;
		this.total = total;
		this.cambio = cambio;
		fecha = LocalDateTime.now();
	}

	public int getId_venta() {
		return id_venta;
	}

	public void setId_venta(int id_venta) {
		this.id_venta = id_venta;
	}

	public long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCambio() {
		return cambio;
	}

	public void setCambio(int cambio) {
		this.cambio = cambio;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

}
