package com.fenixcode.papeleriarosita.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fenixcode.papeleriarosita.DAO.ClienteDAO;
import com.fenixcode.papeleriarosita.DAO.InventarioDAO;
import com.fenixcode.papeleriarosita.DAO.PedidoDAO;
import com.fenixcode.papeleriarosita.DAO.ProductoDAO;
import com.fenixcode.papeleriarosita.DAO.ProveedorDAO;
import com.fenixcode.papeleriarosita.DAO.VentaDAO;
import com.fenixcode.papeleriarosita.DTO.Producto_Cantidad;
import com.fenixcode.papeleriarosita.modelo.Cliente;
import com.fenixcode.papeleriarosita.modelo.Inventario;
import com.fenixcode.papeleriarosita.modelo.Pedido;
import com.fenixcode.papeleriarosita.modelo.Producto;
import com.fenixcode.papeleriarosita.modelo.Proveedor;
import com.fenixcode.papeleriarosita.modelo.Venta;

@Controller
@RequestMapping("/consultas")
public class ControllerConsultas {

	@Autowired
	private ClienteDAO cliente_dao;
	@Autowired
	private ProveedorDAO proveedor_dao;
	@Autowired
	private ProductoDAO producto_dao;
	@Autowired
	private InventarioDAO inventario_dao;
	@Autowired
	private VentaDAO venta_dao;
	@Autowired
	private PedidoDAO pedido_dao;
	
	
	@GetMapping
	public String listar_cliente(Model model) {
		List<Cliente> lista_cliente = cliente_dao.listAll();
		model.addAttribute("lista_cliente_all", lista_cliente);
		//--
		List<Producto> lista_producto = producto_dao.listAll();
		model.addAttribute("lista_producto_all", lista_producto);
		//--
		List<Proveedor>lista_proveedor=proveedor_dao.listAll();
		model.addAttribute("lista_proveedor_all",lista_proveedor);
		//----
		List<Inventario> lista_inventario = inventario_dao.list_all_inventario();
		List<Producto_Cantidad> lista_producto_cantidad=new ArrayList<>();
				
		for (int i = 0; i < lista_inventario.size(); i++) {
			Producto producto = producto_dao.findIdProducto(lista_inventario.get(i).getId_producto()).orElse(null);	
			lista_producto_cantidad.add(new Producto_Cantidad(producto.getNom_producto(),lista_inventario.get(i).getCantidad()));
		}
		
		model.addAttribute("lista_inventario", lista_producto_cantidad);
		
		List<Venta> lista_venta = venta_dao.listAll();
		model.addAttribute("lista_venta_all", lista_venta);
		
		List<Pedido>lista_pedido = pedido_dao.listAll();
		model.addAttribute("lista_pedido_all", lista_pedido);
		
		return "consultas";
	}

}
