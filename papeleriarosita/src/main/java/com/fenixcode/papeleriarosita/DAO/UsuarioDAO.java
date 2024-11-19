package com.fenixcode.papeleriarosita.DAO;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenixcode.papeleriarosita.interfaceService.UsuarioCRUDMethod;
import com.fenixcode.papeleriarosita.interfaces.UsuarioCRUD;
import com.fenixcode.papeleriarosita.modelo.Usuario;

@Service
public class UsuarioDAO implements UsuarioCRUDMethod{

	@Autowired
	private UsuarioCRUD usuario_method;
	
	@Override
	public Optional<Usuario> findId(String usuario) {
		// TODO Auto-generated method stub
		return usuario_method.findById(usuario);
	}

}
