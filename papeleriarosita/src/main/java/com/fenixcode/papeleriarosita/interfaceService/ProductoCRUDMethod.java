package com.fenixcode.papeleriarosita.interfaceService;

import java.util.List;
import java.util.Optional;

import com.fenixcode.papeleriarosita.modelo.Producto;

public interface ProductoCRUDMethod {
	public List<Producto> listAll();

	public Optional<Producto> findIdProducto(Integer id);

	public Producto saveProducto(Producto producto);

	public Producto updateProducto(Integer id_producto, Integer id_proveedor, String nom_producto, Double precio);

	public String deleteProducto(Integer id_producto);

}
