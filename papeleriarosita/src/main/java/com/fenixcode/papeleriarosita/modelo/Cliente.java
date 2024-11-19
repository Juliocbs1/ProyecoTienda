package com.fenixcode.papeleriarosita.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente {

	@Id
	private long id_cliente;
	@Column(name = "nom_cliente")
	private String nom_cliente;

	public Cliente() {
		
	}

	public Cliente(long id_cliente, String nom_cliente) {
		super();
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
