package com.fenixcode.papeleriarosita.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.fenixcode.papeleriarosita.DTO.ClienteDTO;
import com.fenixcode.papeleriarosita.interfaceService.ClienteCRUDMethod;
import com.fenixcode.papeleriarosita.interfaces.ClienteCRUD;
import com.fenixcode.papeleriarosita.modelo.Cliente;

@Service
public class ClienteDAO implements ClienteCRUDMethod {

	@Autowired
	private ClienteCRUD cliente_method;

	@Override
	public List<Cliente> listAll() {

		return  cliente_method.findAll();
	}

	@Override
	public Optional<Cliente> findId(Long id) {

		return cliente_method.findById(id);
	}

	@Override
	public Cliente saveCliente(Cliente cliente) {

		return cliente_method.save(cliente);
	}

	@Override
	public Cliente updateCliente(Long id_cliente, String nombre) {
		Cliente cliente = cliente_method.findById(id_cliente).get();
		cliente.setNom_cliente(nombre);
		cliente_method.save(cliente);
		return cliente;
	}

	@Override
	public String deleteCliente(Long id_cliente) {
		Cliente cliente = cliente_method.findById(id_cliente).get();
		String cliente_eliminar = "El cliente eliminado " + cliente.getNom_cliente() + " con su id  "
				+ cliente.getId_cliente();
		cliente_method.delete(cliente);
		return cliente_eliminar;
	}



}
