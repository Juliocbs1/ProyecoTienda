package com.fenixcode.papeleriarosita.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fenixcode.papeleriarosita.DAO.ClienteDAO;
import com.fenixcode.papeleriarosita.DAO.ProveedorDAO;
import com.fenixcode.papeleriarosita.DTO.ClienteDTO;
import com.fenixcode.papeleriarosita.DTO.ProveedorDTO;
import com.fenixcode.papeleriarosita.modelo.Cliente;
import com.fenixcode.papeleriarosita.modelo.Proveedor;

@org.springframework.stereotype.Controller
@RequestMapping("/cliente")
public class ControllerCliente {
	


	@Autowired
	private ClienteDAO cliente_dao;
	
	private String msg;

	@GetMapping
	public String gestion_cliente(Model model) {
		msg = "";
		return "crud_cliente";
	}



	@PostMapping("/cliente_id")
	public String buscar_cliente_id(@RequestParam("id_cliente") Long id, Model model) {
		try {
			String size = id.toString();
			if(size.length() >= 8 && size.length() <= 11) {
				Cliente cliente_id = cliente_dao.findId(id).orElse(null);
				if (cliente_id != null) {
					msg = "El nombre del cliente es: \n" + cliente_id.getNom_cliente();
					model.addAttribute("resultado", msg);
				} else {
					msg="Cliente no encontrado";
					model.addAttribute("resultado", msg);
				}
				return "crud_cliente";
			}else {
				msg="La cedula debe ser mayor a 8 digitos y menor a 11";
				model.addAttribute("resultado", msg);
				return "crud_cliente";
			}
		} catch (Exception e) {
			msg = "Algo salio mal";
			model.addAttribute("resultado", msg);
			return "crud_cliente";
		}
		
		

	}

	@PostMapping("/ingresar_cliente")
	public String ingresar_cliente(@RequestParam("id_cliente") Long id, @RequestParam("nom_cliente") String nombre,
			Model model) {
		try {
			String size = id.toString();
			if(size.length() >= 8 && size.length() <= 11) {

			Cliente cliente = new Cliente(id, nombre);
			if (cliente_dao.findId(id).isPresent()) {
				msg = "Cliente ya existe";
				model.addAttribute("resultado", msg);
				return "crud_cliente";
			} else {
				cliente_dao.saveCliente(cliente);
				msg = "Exito en el guardado para " + cliente.getNom_cliente();
				model.addAttribute("resultado", msg);
				return "crud_cliente";
			}
			}else {
				msg = "La cedula debe ser mayor a 8 digitos y menor a 11";
				model.addAttribute("resultado", msg);
				return "crud_cliente";
			}
		} catch (Exception e) {
			msg = "Fallo en el guardado";
			model.addAttribute("resultado", msg);
			return "crud_cliente";
		}

	}

	@PostMapping("/actualizar_cliente")
	public String actualizar_cliente(@RequestParam("id_cliente") Long id, @RequestParam("nom_cliente") String nombre,
			Model model) {
		try {
			String size = id.toString();
			if(size.length() >= 8 && size.length() <= 11) {
			String cliente_viejo = cliente_dao.findId(id).orElse(null).getNom_cliente();

			Cliente cliente = cliente_dao.updateCliente(id, nombre);
			msg = "Exito en el actualizado para " + cliente_viejo
					+ " a el nuevo nombre " + cliente.getNom_cliente();
			model.addAttribute("resultado", msg);
			return "crud_cliente";
			}else {
				msg =  "La cedula debe ser mayor a 8 digitos y menor a 11";
				model.addAttribute("resultado",msg);
				return "crud_cliente";
			}

		} catch (Exception e) {
			msg = "Fallo en la actualizacion";
			model.addAttribute("resultado", msg);
			return "crud_cliente";
		}
	}

	@PostMapping("/eliminar_cliente")
	public String eliminar_cliente(@RequestParam("id_cliente") Long id_cliente, Model model) {
		try {
			String size = id_cliente.toString();
			if(size.length() >= 8 && size.length() <= 11) {

			msg = cliente_dao.deleteCliente(id_cliente);

			model.addAttribute("resultado", msg);
			return "crud_cliente";
			}else {
				msg = "La cedula debe ser mayor a 8 digitos y menor a 11";
				model.addAttribute("resultado", msg);
				return "crud_cliente";
			}

		} catch (Exception e) {
			msg = "Fallo en eliminar";
			model.addAttribute("resultado", msg);
			return "crud_cliente";
		}

	}

}
