package com.fenixcode.papeleriarosita.interfaceService;

import java.util.List;
import java.util.Optional;

import com.fenixcode.papeleriarosita.modelo.Cliente;

public interface ClienteCRUDMethod {
	public List<Cliente> listAll();

	public Optional<Cliente> findId(Long id);

	public Cliente saveCliente(Cliente cliente);

	public Cliente updateCliente(Long id_cliente, String nombre);

	public String deleteCliente(Long id_cliente);
}
