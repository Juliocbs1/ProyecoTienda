package com.fenixcode.papeleriarosita.interfaceService;

import java.util.List;
import java.util.Optional;

import com.fenixcode.papeleriarosita.modelo.Proveedor;
import com.fenixcode.papeleriarosita.modelo.Venta;

public interface VentaCRUDMethod {
	public List<Venta> listAll();

	public Optional<Venta> findIdventa(int id);

	public Venta saveventa(Venta venta);

	public Venta updateventa(int iD_VENTA, int iD_CLIENTE, int tOTAL, int cAMBIO);

	public String deleteventa(int id_venta);

}
