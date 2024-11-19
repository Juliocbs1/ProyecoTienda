package com.fenixcode.papeleriarosita.interfaceService;

import java.util.List;
import java.util.Optional;

import com.fenixcode.papeleriarosita.modelo.ProductoComprado;

public interface ProductoCompradoCRUDMethod {
	
	public List<ProductoComprado> listAll();

	public Optional<ProductoComprado> findId(Integer id);

	public ProductoComprado saveproductoComprado(ProductoComprado productoComprado);

	public ProductoComprado updateproductoComprado(Integer id_productoComprado, Integer id_producto, Integer cantidad_producto);

	public String deleteproductoComprado(Integer id_productoComprado);

}
