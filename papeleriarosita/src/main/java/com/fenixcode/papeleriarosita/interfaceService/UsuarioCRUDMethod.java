package com.fenixcode.papeleriarosita.interfaceService;

import java.util.Optional;

import com.fenixcode.papeleriarosita.modelo.Cliente;
import com.fenixcode.papeleriarosita.modelo.Usuario;

public interface UsuarioCRUDMethod {

	public Optional<Usuario> findId(String usuario);
	
}
