package com.fenixcode.papeleriarosita.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fenixcode.papeleriarosita.interfaceService.PedidoCRUDMethod;
import com.fenixcode.papeleriarosita.interfaces.PedidoCRUD;
import com.fenixcode.papeleriarosita.modelo.Pedido;

@Service
public class PedidoDAO implements PedidoCRUDMethod{

	@Autowired
	private PedidoCRUD pedido_method;
	
	@Override
	public List<Pedido> listAll() {
		
		return pedido_method.findAll();
	}

	@Override
	public Optional<Pedido> findId(Integer id) {
		
		return pedido_method.findById(id);
	}

	@Override
	public Pedido savePedido(Pedido pedido) {
		// TODO Auto-generated method stub
		return pedido_method.save(pedido);
	}

	@Override
	public Pedido updatePedido(Integer id_pedido, Integer id_proveedor, Integer id_producto, Integer costo,
			Integer cantidad, boolean pedido_especial) {
		
	Pedido pedido = pedido_method.findById(id_pedido).orElse(null);
	pedido.setId_proveedor(id_proveedor);
	pedido.setId_producto(id_producto);
	pedido.setCosto(costo);
	pedido.setCantidad(cantidad);
	pedido.setPedido_especial(pedido_especial);
	pedido_method.save(pedido);
	
		return pedido;
	}

	@Override
	public String deletePedido(Integer id_pedido) {
	Pedido pedido = pedido_method.findById(id_pedido).get();
	String pedido_eliminar = "El pedido eliminado "+pedido.getId_pedido();
		return pedido_eliminar;
	}

}
