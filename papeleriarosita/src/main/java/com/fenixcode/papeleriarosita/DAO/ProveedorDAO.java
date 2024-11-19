package com.fenixcode.papeleriarosita.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenixcode.papeleriarosita.DTO.ProveedorDTO;
import com.fenixcode.papeleriarosita.interfaceService.ProveedorCRUDMethod;
import com.fenixcode.papeleriarosita.interfaces.ProveedorCRUD;
import com.fenixcode.papeleriarosita.modelo.Proveedor;

@Service
public class ProveedorDAO implements ProveedorCRUDMethod{
	
	@Autowired
	private ProveedorCRUD proveedor_method;
	
	@Override
	public List<Proveedor> listAll() {
		return (List<Proveedor>)proveedor_method.findAll();
	}

	@Override
	public Optional<Proveedor> findIdProveedor(Long id) {
		
		return proveedor_method.findById(id);
	}

	@Override
	public Proveedor saveProveedor(Proveedor proveedor) {
		
		return proveedor_method.save(proveedor);
	}

	@Override
	public Proveedor updateProveedor(Long id_proveedor, String nom_proveedor, long telefono) {
		Proveedor proveedor = proveedor_method.findById(id_proveedor).get();
		proveedor.setNom_proveedor(nom_proveedor);
		proveedor.setTelefono(telefono);
		proveedor_method.save(proveedor);
		return proveedor;
	}

	@Override
	public String deleteProveedor(Long id_proveedor) {
		Proveedor proveedor = proveedor_method.findById(id_proveedor).get();
		String proveedor_eliminar = "El proveedor eliminado " + proveedor.getNom_proveedor() + " con su id "
				+ proveedor.getId_proveedor();
		proveedor_method.delete(proveedor);
		return proveedor_eliminar;
	}

}
