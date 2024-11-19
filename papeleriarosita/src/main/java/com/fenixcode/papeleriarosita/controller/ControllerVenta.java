package com.fenixcode.papeleriarosita.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fenixcode.papeleriarosita.DAO.ClienteDAO;
import com.fenixcode.papeleriarosita.DAO.InventarioDAO;
import com.fenixcode.papeleriarosita.DAO.ProductoCompradoDAO;
import com.fenixcode.papeleriarosita.DAO.ProductoDAO;
import com.fenixcode.papeleriarosita.DAO.VentaDAO;
import com.fenixcode.papeleriarosita.DTO.ProductoVenta;
import com.fenixcode.papeleriarosita.modelo.Cliente;
import com.fenixcode.papeleriarosita.modelo.Inventario;
import com.fenixcode.papeleriarosita.modelo.Producto;
import com.fenixcode.papeleriarosita.modelo.ProductoComprado;
import com.fenixcode.papeleriarosita.modelo.Proveedor;
import com.fenixcode.papeleriarosita.modelo.Venta;
import com.fenixcode.papeleriarosita.reportes.VentasExportExcel;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/venta")
public class ControllerVenta {

	@Autowired
	private VentaDAO venta_dao;
	@Autowired
	private ClienteDAO cliente_dao;
	@Autowired
	private ProductoDAO producto_dao;
	@Autowired
	private ProductoCompradoDAO productoComprado_dao;

	@Autowired
	private InventarioDAO inventario_dao;

	private Cliente cliente;
	private String msg = "";
	private Map<String, String> cantidad;
	private List<Integer> id_producto;
	private List<ProductoVenta> producto_venta;
	private double total;
	private String msg_efectivo = "";
	private double cambio;
	private String msg_advertencia = "";
	private String error_selec_produc = "";

	@GetMapping
	public String redireccionar(Model model) {

		model.addAttribute("mensaje", msg);
		model.addAttribute("mensaje_advertencia", msg_advertencia);
		msg_efectivo = "";
		msg = "";
		msg_advertencia = "";
		return "venta_paso1_ver_cliente";
	}

	// ----------------------------PASO1------------------------------

	@PostMapping("/verificar_cliente")
	public String verificarCliente(@RequestParam("cedula_ini") long id, Model model) {
		if (cliente_dao.findId(id).isPresent()) {
			this.cliente = cliente_dao.findId(id).get();
			msg = "El cliente es: " + cliente.getNom_cliente();

			return "redirect:/venta/tabla_productos_venta";
		} else {

			model.addAttribute("mensaje", "El cliente no esta registrado");
			return "venta_paso1_ver_cliente";
		}

	}

	@PostMapping("/ingresar_cliente")
	public String ingresar_cliente(@RequestParam("cedula") Long id, @RequestParam("nombre_cl") String nombre,
			Model model) {
		try {
			String size = id.toString();
			if (size.length() >= 8 && size.length() <= 11) {
				Cliente cliente = new Cliente(id, nombre);
				if (cliente_dao.findId(id).isPresent()) {
					this.cliente = cliente;
					msg = "Cliente ya existe, su nombre es: " + cliente.getNom_cliente();
					return "redirect:/venta/tabla_productos_venta";
				} else {
					cliente_dao.saveCliente(cliente);
					this.cliente = cliente;
					msg = "Exito en el guardado para " + cliente.getNom_cliente();
					return "redirect:/venta/tabla_productos_venta";
				}
			} else {
				msg = "La cedula debe ser mayor a 8 digitos y menor a 11";
				model.addAttribute("mensaje", msg);
				return "venta_paso1_ver_cliente";
			}
		} catch (Exception e) {
			model.addAttribute("mensaje", "Fallo en el guardado");
			return "venta_paso1_ver_cliente";
		}

	}

	// ----------------------------PASO2------------------------------
	@GetMapping("/tabla_productos_venta")
	public String tabla_productos_venta(Model model) {
		model.addAttribute("error_select", error_selec_produc);
		List<Producto> lista_producto = producto_dao.listAll();
		model.addAttribute("lista_producto_all", lista_producto);
		model.addAttribute("mensaje", msg);

		return "venta_paso2_selec_prod";
	}

	@PostMapping("/seleccion_productos")
	public String seleccion_productos(@RequestParam Map<String, String> formData,
			@RequestParam("opcion") List<Integer> prueba, Model model) {
		try {
			cantidad = formData;
			id_producto = prueba;
			producto_venta = new ArrayList<>();
			Producto p = new Producto();
			double total = 0;
			int cantidadActual = 0;

			for (Integer long1 : id_producto) {
				p = producto_dao.findIdProducto(long1).orElse(null);
				cantidadActual = Integer.parseInt(cantidad.get("cantidad_" + long1.toString()));
				producto_venta.add(new ProductoVenta(p.getNom_producto(), p.getPrecio(), cantidadActual));
				total += p.getPrecio() * cantidadActual;

			}

			model.addAttribute("mensaje", "Nombre: " + this.cliente.getNom_cliente());
			model.addAttribute("mensaje", msg_efectivo);
			model.addAttribute("lista_producto_venta_all", producto_venta);
			model.addAttribute("total", total);
			this.total = total;
			return "venta_paso3_resum_pago";
		} catch (Exception e) {
			error_selec_produc = "Ingrese la cantidad de los productos seleccionados.";
			return "redirect:/venta/tabla_productos_venta";
		}

	}

	//

	@PostMapping("/factura")
	public String factura(@RequestParam("efectivo") double efectivo, Model model) {

		double cambio = efectivo - total;

		if (cambio < 0) {
			msg = "Efectivo insuficiente";

			return "redirect:/venta/tabla_productos_venta";
		} else {
			this.cambio = cambio;
			model.addAttribute("mensaje", "Nombre: " + this.cliente.getNom_cliente());
			model.addAttribute("lista_producto_venta_all", producto_venta);
			model.addAttribute("total", total);
			model.addAttribute("efectivo", efectivo);
			model.addAttribute("cambio", cambio);
			model.addAttribute("nom_cliente", cliente.getNom_cliente());
			model.addAttribute("cedula", cliente.getId_cliente());

			return "venta_paso4_cambio";
		}
	}

	@GetMapping("/terminar_venta")
	public String terminar_venta(Model model) {
		try {
			// generar venta
			Venta venta = new Venta(cliente.getId_cliente(), (int) total, (int) cambio);
			venta_dao.saveventa(venta);
			int cantidad_resultante = 0;
			int cantidad_Actual = 0;

			// producto_comprado
			for (Integer id : id_producto) {

				cantidad_Actual = Integer.parseInt(cantidad.get("cantidad_" + id.toString()));

				Inventario inventario = inventario_dao.findIdInventario(id).orElse(null);

				cantidad_resultante = inventario.getCantidad() - cantidad_Actual;
				if (cantidad_resultante < 0) {
					venta_dao.deleteventa(venta.getId_venta());
					msg_advertencia += "Venta fallida , falta de productos en el inventario: "
							+ producto_dao.findIdProducto(id).get().getNom_producto() + ". ";
					return "redirect:/venta";
				} else {
					inventario_dao.updateInventario(inventario.getId_producto(), cantidad_resultante);
					ProductoComprado pc = new ProductoComprado(venta.getId_venta(), id,
							Integer.parseInt(cantidad.get("cantidad_" + id.toString())));
					productoComprado_dao.saveproductoComprado(pc);

					if (cantidad_resultante <= 10) {
						msg_advertencia += " Advertencia este producto tienen 10 o menos existencias en el inventario "
								+ producto_dao.findIdProducto(id).get().getNom_producto() + ". \n";
					}

				}

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			msg = "Venta defectuosa";
			return "redirect:/venta";
		}
		msg = "Venta exitosa";
		return "redirect:/venta";

	}
// EXPORTAR EXCEL
	
	@GetMapping("/exportarExcel")
	public void exportarListadoVentasExcel(HttpServletResponse response) {
		response.setContentType("application/octet-stream");
		
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String fechaActual = dateFormatter.format(new Date());
		
		String cabecera = "Content-Disposition";
		String valor ="attachment; filename=Ventas_"+fechaActual+".xlsx";
		
		response.setHeader(cabecera, valor);
		
		List<Venta> ventas = venta_dao.listAll();
		
		VentasExportExcel exporter= new VentasExportExcel(ventas);
		try {
			exporter.exportar(response);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		}
}
