package com.fenixcode.papeleriarosita.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usuario")
public class Usuario {

	@Id
	private String usuario;
	private String contra;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Usuario(String usuario, String contra) {
		super();
		this.usuario = usuario;
		this.contra = contra;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContra() {
		return contra;
	}

	public void setContra(String contra) {
		this.contra = contra;
	}
	
}
