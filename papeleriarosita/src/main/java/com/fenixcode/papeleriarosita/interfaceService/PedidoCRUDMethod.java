package com.fenixcode.papeleriarosita.interfaceService;

import java.util.List;
import java.util.Optional;

import com.fenixcode.papeleriarosita.modelo.Pedido;



public interface PedidoCRUDMethod {

	public List<Pedido> listAll();

	public Optional<Pedido> findId(Integer id);

	public Pedido savePedido(Pedido pedido);

	public Pedido updatePedido(Integer id_pedido, Integer id_proveedor, Integer id_producto, Integer costo,
			Integer cantidad, boolean pedido_especial);

	public String deletePedido(Integer id_pedido);

}
