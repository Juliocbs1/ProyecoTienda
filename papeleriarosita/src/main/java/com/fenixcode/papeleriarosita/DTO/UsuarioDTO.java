package com.fenixcode.papeleriarosita.DTO;

public class UsuarioDTO {
	
	private String usuario;
	private String contra;
	
	public UsuarioDTO() {
		// TODO Auto-generated constructor stub
	}

	public UsuarioDTO(String usuario, String contra) {
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
