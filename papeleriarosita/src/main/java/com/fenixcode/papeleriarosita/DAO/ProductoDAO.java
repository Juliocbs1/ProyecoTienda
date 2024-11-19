package com.fenixcode.papeleriarosita.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenixcode.papeleriarosita.interfaceService.ProductoCRUDMethod;
import com.fenixcode.papeleriarosita.interfaces.ProductoCRUD;
import com.fenixcode.papeleriarosita.modelo.Producto;
@Service
public class ProductoDAO implements ProductoCRUDMethod{
	
	@Autowired
	private ProductoCRUD producto_method;

	@Override
	public List<Producto> listAll() {
	
		return producto_method.findAll();
	}

	@Override
	public Optional<Producto> findIdProducto(Integer id) {
	
		return producto_method.findById(id);
	}

	@Override
	public Producto saveProducto(Producto producto) {
		
		return producto_method.save(producto);
	}

	@Override
	public Producto updateProducto(Integer id_producto, Integer id_proveedor, String nom_producto, Double precio) {
		Producto producto = producto_method.findById(id_producto).get();
		producto.setId_proveedor(id_proveedor);
		producto.setNom_producto(nom_producto);
		producto.setPrecio(precio);
		producto_method.save(producto);
		return producto;
	}

	@Override
	public String deleteProducto(Integer id_producto) {
		Producto producto = producto_method.findById(id_producto).get();
		String producto_eliminar = "El producto eliminado "+producto.getNom_producto()+" con su id "+
		+ producto.getId_producto();
		producto_method.delete(producto);
		return producto_eliminar;
	}

}
