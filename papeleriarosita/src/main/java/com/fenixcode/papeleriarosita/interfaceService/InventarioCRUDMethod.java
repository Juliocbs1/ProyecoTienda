package com.fenixcode.papeleriarosita.interfaceService;

import java.util.List;
import java.util.Optional;

import com.fenixcode.papeleriarosita.modelo.Inventario;


public interface InventarioCRUDMethod {
	
	public List<Inventario> list_all_inventario();
	public Optional<Inventario> findIdInventario(Integer id);

	public Inventario saveInventarioProducto(Inventario inventario);


	public String updateInventario(Integer id_producto, Integer cantidad);

}
