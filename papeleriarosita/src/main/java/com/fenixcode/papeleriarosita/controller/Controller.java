package com.fenixcode.papeleriarosita.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fenixcode.papeleriarosita.DAO.UsuarioDAO;
import com.fenixcode.papeleriarosita.DAO.VentaDAO;
import com.fenixcode.papeleriarosita.modelo.Venta;
import com.fenixcode.papeleriarosita.reportes.VentasExportExcel;

import jakarta.servlet.http.HttpServletResponse;

@org.springframework.stereotype.Controller
public class Controller {
	
	private int permisos;
	
	@Autowired
	private UsuarioDAO usuario_dao;
	
	@Autowired
	private VentaDAO venta_dao;
	
	

	@GetMapping("/")
	public String inicio() {
		return "login";
	}
	
	@PostMapping("/home")
	public String login(@RequestParam("usuario") String usuario,
			@RequestParam("contrasenia") String contrasenia, Model model) {
		if(usuario_dao.findId(usuario).isPresent() &&
				usuario_dao.findId(usuario).get().getContra().equals(contrasenia)) {
			
			if(usuario.equals("administrador")) {
				model.addAttribute("ver_cliente", true);
				model.addAttribute("ver_pro_inv", true);
				model.addAttribute("ver_proveedor", true);
				model.addAttribute("ver_consultas", true);
			}else if(usuario.equals("dependiente")){
				model.addAttribute("ver_cliente", false);
				model.addAttribute("ver_pro_inv", false);
				model.addAttribute("ver_proveedor", false);
				model.addAttribute("ver_consultas", false);
			}
			
			return "index";
		}else {
			model.addAttribute("advertencia","Usuario o contraseña incorrectas");
			return "login";
		}
	}
	
}
