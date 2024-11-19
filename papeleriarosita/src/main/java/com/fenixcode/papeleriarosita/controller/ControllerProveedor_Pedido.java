package com.fenixcode.papeleriarosita.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fenixcode.papeleriarosita.DAO.InventarioDAO;
import com.fenixcode.papeleriarosita.DAO.PedidoDAO;
import com.fenixcode.papeleriarosita.DAO.ProductoDAO;
import com.fenixcode.papeleriarosita.DAO.ProveedorDAO;
import com.fenixcode.papeleriarosita.modelo.Pedido;
import com.fenixcode.papeleriarosita.modelo.Producto;
import com.fenixcode.papeleriarosita.modelo.Proveedor;

@Controller
@RequestMapping("/proveedor")
public class ControllerProveedor_Pedido {

	@Autowired
	private ProveedorDAO proveedor_dao;

	@Autowired
	private PedidoDAO pedido_dao;
	
	@Autowired 
	private ProductoDAO producto_dao;

	@Autowired
	private InventarioDAO inventario_dao;
	
	private String msg_proveedor = "";
	private String msg_pedido = "";

	@GetMapping
	public String gestion_proveedor(Model model) {
		
		List<Producto> lista_producto = producto_dao.listAll();
		
		model.addAttribute("lista_producto_all", lista_producto);
		model.addAttribute("resultado", msg_proveedor);
		model.addAttribute("resultado_pedido", msg_pedido);
		
		//lista proveedor
		List<Proveedor> lista_proveedor = proveedor_dao.listAll();
		model.addAttribute("lista_proveedor_all", lista_proveedor);
		//lista pedido
		List<Pedido> lista_pedido = pedido_dao.listAll();
		model.addAttribute("lista_pedido_all", lista_pedido);
		msg_proveedor = "";
		msg_pedido = "";
		return "crud_proveedor_pedido";
	}

	// PROVEEDOR
	@PostMapping("/proveedor_id")
	public String buscar_proveedor_id(@RequestParam("id_proveedor") Long id) {
		try {
			Proveedor proveedor_id = proveedor_dao.findIdProveedor(id).orElse(null);
			if (proveedor_id != null) {
				msg_proveedor = "Nombre proveedor: " + proveedor_id.getNom_proveedor() + "\n " 
								+ "Telefono del proveedor:  "+ proveedor_id.getTelefono();
				return "redirect:/proveedor";
			} else {
				msg_proveedor = "Proveedor no encontrado";
				return "redirect:/proveedor";
			}
		} catch (Exception e) {
			msg_proveedor = "Seleccione un proveedor";
			return "redirect:/proveedor";
		}
		

	}

	@PostMapping("/ingresar_proveedor")
	public String ingresar_proveedor(
			@RequestParam("nombre_proveedor") String nom, @RequestParam("telefono_proveedor") Long telefono) {
		try {
			Proveedor proveedor = new Proveedor(nom, telefono);
			if (proveedor_dao.findIdProveedor(proveedor.getId_proveedor()).isPresent()) {
				msg_proveedor = "Proveedor ya existe";
				return "redirect:/proveedor";
			} else {
				proveedor_dao.saveProveedor(proveedor);
				msg_proveedor = "Exito en el guardado para " + proveedor.getNom_proveedor();
				return "redirect:/proveedor";
			}
		} catch (Exception e) {
			msg_proveedor = "Fallo en guardar el proveedor";
			return "redirect:/proveedor";
		}
	}

	@PostMapping("/actualizar_proveedor")
	public String actualizar_cliente(@RequestParam("id_proveedor_a") Long id,
			@RequestParam("nom_proveedor_a") String nombre, @RequestParam("telefono_proveedor_a") Long telefono) {
		try {
			String proveedor_viejo = proveedor_dao.findIdProveedor(id).orElse(null).getNom_proveedor();
			Proveedor proveedor = proveedor_dao.updateProveedor(id, nombre, telefono);
			msg_proveedor = "Exito en el actualizado para " + proveedor_viejo + " a el nuevo nombre "
					+ proveedor.getNom_proveedor() + ", con el nuevo numero " + proveedor.getTelefono();
			return "redirect:/proveedor";
		} catch (Exception e) {
			msg_proveedor = "Fallo en la actualizacion";
			return "redirect:/proveedor";
		}
	}

	@PostMapping("/eliminar_proveedor")
	public String eliminar_proveedor(@RequestParam("id_proveedor_e") Long id_proveedor) {
		try {
			String resultado = proveedor_dao.deleteProveedor(id_proveedor);
			msg_proveedor = resultado;
			return "redirect:/proveedor";
		} catch (Exception e) {
			msg_proveedor = "Fallo en eliminar, el proveedor esta relacionado con al menos un producto o inventario";
			return "redirect:/proveedor";
		}

	}

	// PEDIDO
	@PostMapping("/pedido_id")
	public String buscar_pedido_id(@RequestParam("id_pedido") Integer id) {

		Pedido pedido_id = pedido_dao.findId(id).orElse(null);
		if (pedido_id != null) {
			msg_pedido = " Id del pedido: " + pedido_id.getId_pedido() + "\n Id_proveedor: " + pedido_id.getId_proveedor()
					+ "\n Cantidad: " + pedido_id.getCantidad() + "\n Id_producto: " + pedido_id.getId_producto() + "\n costo: "
					+ pedido_id.getCosto()
					+ "\n Fecha: " + pedido_id.getFecha_pedido_entrega();
			return "redirect:/proveedor";
		} else {
			msg_pedido = "Pedido no encontrado";
			return "redirect:/proveedor";
		}

	}
	@PostMapping("/ingresar_pedido")
	public String ingresar_pedido(@RequestParam("id_producto") Integer id_producto,@RequestParam("costo") Integer costo,@RequestParam("cantidad") Integer cantidad,@RequestParam("pedido_especial") String pedido_especial) {
		try {
			int id_proveedor = producto_dao.findIdProducto(id_producto).orElseGet(null).getId_proveedor();
			Pedido pedido = new Pedido(id_proveedor, id_producto, costo, cantidad, Boolean.parseBoolean(pedido_especial));
			pedido_dao.savePedido(pedido);
			int cantidad_inventario_anterior = inventario_dao.findIdInventario(id_producto).orElseGet(null).getCantidad();
			int cantidad_actual=cantidad+cantidad_inventario_anterior;
			inventario_dao.updateInventario(id_producto, cantidad_actual);
			msg_pedido ="Se guardo el pedido "+pedido.getId_pedido()+" y se actualizo en el inventario ";
			return "redirect:/proveedor";
		} catch (Exception e) {
			msg_pedido ="Hubo un error en el pedido, verifica que el proveedor ";
			return "redirect:/proveedor";
		}
		
		
	}

}
