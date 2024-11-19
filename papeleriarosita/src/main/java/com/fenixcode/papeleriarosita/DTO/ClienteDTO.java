package com.fenixcode.papeleriarosita.DTO;

public class ClienteDTO {


	private long id_cliente;

	private String nom_cliente;

	public ClienteDTO() {
		
	}

	public ClienteDTO(long id_cliente, String nom_cliente) {
		
		this.id_cliente = id_cliente;
		this.nom_cliente = nom_cliente;
	}

	public long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNom_cliente() {
		return nom_cliente;
	}

	public void setNom_cliente(String nom_cliente) {
		this.nom_cliente = nom_cliente;
	}
	

}
