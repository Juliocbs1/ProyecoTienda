package com.fenixcode.papeleriarosita.interfaceService;

import java.util.List;
import java.util.Optional;

import com.fenixcode.papeleriarosita.modelo.Proveedor;

public interface ProveedorCRUDMethod {
	public List<Proveedor> listAll();

	public Optional<Proveedor> findIdProveedor(Long id);
	
	public Proveedor saveProveedor(Proveedor proveedor);
	
	public Proveedor updateProveedor(Long id_proveedor, String nom_proveedor, long telefono);

	public String deleteProveedor(Long id_proveedor);
}
