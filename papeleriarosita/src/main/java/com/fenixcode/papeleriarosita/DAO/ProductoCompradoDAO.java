package com.fenixcode.papeleriarosita.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenixcode.papeleriarosita.interfaceService.ProductoCompradoCRUDMethod;
import com.fenixcode.papeleriarosita.interfaces.ProductoCompradoCRUD;
import com.fenixcode.papeleriarosita.modelo.ProductoComprado;

@Service
public class ProductoCompradoDAO implements ProductoCompradoCRUDMethod {

	@Autowired
	private ProductoCompradoCRUD productoComprado_method;

	@Override
	public List<ProductoComprado> listAll() {

		return productoComprado_method.findAll();
	}

	@Override
	public Optional<ProductoComprado> findId(Integer id) {
		// TODO Auto-generated method stub
		return productoComprado_method.findById(id);
	}

	@Override
	public ProductoComprado saveproductoComprado(ProductoComprado productoComprado) {
		
		return productoComprado_method.save(productoComprado);
	}

	@Override
	public ProductoComprado updateproductoComprado(Integer id_productoComprado, Integer id_producto,
			Integer cantidad_producto) {
		ProductoComprado productoComprado = productoComprado_method.findById(id_productoComprado).get();
		productoComprado.setID_PRODUCTO(id_producto);
		productoComprado.setCANTIDAD_PRODUCTO(cantidad_producto);
		productoComprado_method.save(productoComprado);
		return productoComprado;
	}

	@Override
	public String deleteproductoComprado(Integer id_productoComprado) {
		ProductoComprado productoComprado = productoComprado_method.findById(id_productoComprado).get();
		String productoComprado_eliminar = "El producto comprado a eliminar es: " + productoComprado.getID_PRODUCTO_COMPRADO();
		productoComprado_method.delete(productoComprado);
		return null;
	}

}
