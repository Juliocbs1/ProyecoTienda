package com.fenixcode.papeleriarosita.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenixcode.papeleriarosita.interfaceService.VentaCRUDMethod;
import com.fenixcode.papeleriarosita.interfaces.VentaCRUD;
import com.fenixcode.papeleriarosita.modelo.Venta;

@Service
public class VentaDAO implements VentaCRUDMethod{
	
	@Autowired
	private VentaCRUD venta_method;

	@Override
	public List<Venta> listAll() {
		// TODO Auto-generated method stub
		return venta_method.findAll();
	}

	@Override
	public Optional<Venta> findIdventa(int id) {
		// TODO Auto-generated method stub
		return venta_method.findById(id);
	}

	@Override
	public Venta saveventa(Venta venta) {
		// TODO Auto-generated method stub
		return venta_method.save(venta);
	}

	@Override
	public Venta updateventa(int iD_VENTA, int iD_CLIENTE, int tOTAL, int cAMBIO) {
		Venta venta = venta_method.findById(iD_VENTA).get();
		venta.setId_cliente(iD_CLIENTE);
		venta.setTotal(tOTAL);
		venta.setCambio(cAMBIO);
		venta_method.save(venta);
		return venta;
	}

	@Override
	public String deleteventa(int id_venta) {
		Venta venta = venta_method.findById(id_venta).get();
		String venta_eliminada = "La venta con el id " + venta.getId_venta() + " ha sido eliminada";
		venta_method.delete(venta);
		return venta_eliminada;
	}

}
