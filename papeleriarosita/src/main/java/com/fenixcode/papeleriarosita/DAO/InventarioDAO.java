package com.fenixcode.papeleriarosita.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenixcode.papeleriarosita.interfaceService.InventarioCRUDMethod;
import com.fenixcode.papeleriarosita.interfaces.InventarioCRUD;
import com.fenixcode.papeleriarosita.modelo.Inventario;
import com.fenixcode.papeleriarosita.modelo.Producto;

@Service
public class InventarioDAO implements InventarioCRUDMethod {

	@Autowired
	private InventarioCRUD inventario_method;

	@Override
	public List<Inventario> list_all_inventario() {

		return inventario_method.findAll();
	}

	@Override
	public Optional<Inventario> findIdInventario(Integer id) {

		return inventario_method.findById(id);
	}

	@Override
	public String updateInventario(Integer id_producto, Integer cantidad) {
		Inventario inventario = inventario_method.findById(id_producto).orElse(null);
		if (inventario != null) {
			inventario.setCantidad(cantidad);
			inventario_method.save(inventario);
			return "Exito en el actualizado";

		} else {
			return "No se encontro el producto en el inventario";
		}

	}

	@Override
	public Inventario saveInventarioProducto(Inventario inventario) {

		return inventario_method.save(inventario);
	}

}
