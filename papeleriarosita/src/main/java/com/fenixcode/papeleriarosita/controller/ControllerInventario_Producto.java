package com.fenixcode.papeleriarosita.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fenixcode.papeleriarosita.DAO.InventarioDAO;
import com.fenixcode.papeleriarosita.DAO.ProductoDAO;
import com.fenixcode.papeleriarosita.DAO.ProveedorDAO;

import com.fenixcode.papeleriarosita.modelo.Inventario;
import com.fenixcode.papeleriarosita.modelo.Producto;
import com.fenixcode.papeleriarosita.modelo.Proveedor;

@Controller
@RequestMapping("/producto_inventario")
public class ControllerInventario_Producto {

	@Autowired
	private ProductoDAO producto_dao;

	@Autowired
	private ProveedorDAO proveedor_dao;

	@Autowired
	private InventarioDAO inventario_dao;

	private String resultado_producto = "";

	@GetMapping
	public String gestion_producto_pedido(Model model) {
		
		//lista_proveedor
		List<Proveedor> lista_proveedores = proveedor_dao.listAll();
		model.addAttribute("lista_proveedor_all", lista_proveedores);
		model.addAttribute("resultado", resultado_producto);
		resultado_producto="";
		//lista_producto
		List<Producto> lista_producto = producto_dao.listAll();
		model.addAttribute("lista_producto_all", lista_producto);
		return "crud_inventario_producto";
	}

	@PostMapping("/producto_id")
	public String buscar_producto_id(@RequestParam("id_producto") Integer id) {
		Producto producto_id = producto_dao.findIdProducto(id).orElse(null);
		if (producto_id != null) {
			Proveedor proveedor_id = proveedor_dao.findIdProveedor((long)producto_id.getId_proveedor()).orElse(null);
			resultado_producto = "Nombre producto: " + producto_id.getNom_producto() + "\n"
								 + "Precio: " + producto_id.getPrecio() + "\n"
								 + "Proveedor: " + proveedor_id.getNom_proveedor();
			return "redirect:/producto_inventario";

		} else {
			resultado_producto = "Producto no encontrado";

			return "redirect:/producto_inventario";
		}

	}

	@PostMapping("/ingresar_producto")
	public String ingresar_producto(
			@RequestParam("id_proveedor") Integer id_proveedor, @RequestParam("nom_producto") String nom_producto,
			@RequestParam("precio") Double precio) {
		try {
			Producto producto = new Producto(id_proveedor, nom_producto, precio);
			if (producto_dao.findIdProducto(producto.getId_producto()).isPresent()) {
				resultado_producto = "Producto ya existe";

				return "redirect:/producto_inventario";
			} else {
				producto_dao.saveProducto(producto);
				inventario_dao.saveInventarioProducto(new Inventario(producto.getId_producto(), 0));
				resultado_producto = "Exito en el guardado";
				return "redirect:/proveedor";
			}
		} catch (Exception e) {

			resultado_producto = "Fallo en el guardado";
			return "redirect:/producto_inventario";
		}

	}

	@PostMapping("/actualizar_producto")
	public String actualizar_producto(@RequestParam("id_producto") Integer id_producto,
			@RequestParam("id_proveedor") Integer id_proveedor, @RequestParam("nom_producto") String nom_producto,
			@RequestParam("precio") Double precio) {
		try {
			Producto producto_viejo_verificar = producto_dao.findIdProducto(id_producto).orElse(null);
			String producto_viejo = producto_dao.findIdProducto(id_producto).orElse(null).getNom_producto();
			if (producto_viejo_verificar != null) {
				Producto producto_nuevo = producto_dao.updateProducto(id_producto, id_proveedor, nom_producto, precio);
				resultado_producto = "Exito en el actualizado para " + producto_viejo + " a el nuevo producto "
						+ producto_nuevo.getNom_producto();

				return "redirect:/producto_inventario";
			} else {
				resultado_producto = "Fallo en la busqueda del producto a actualiza";
				return "redirect:/producto_inventario";
			}
		} catch (Exception e) {
			resultado_producto = "Fallo en la actualizacion";
			return "redirect:/producto_inventario";
		}
	}

	@PostMapping("/eliminar_producto")
	public String eliminar_producto(@RequestParam("id_producto") Integer id_producto, Model model) {
		try {
			String resultado = producto_dao.deleteProducto(id_producto);
			resultado_producto = resultado;
			return "redirect:/producto_inventario";
		} catch (Exception e) {
			resultado_producto = "Fallo al eliminar, el producto puede estar asociado a un historial de ventas!!";
			return "redirect:/producto_inventario";
		}
	}

}
