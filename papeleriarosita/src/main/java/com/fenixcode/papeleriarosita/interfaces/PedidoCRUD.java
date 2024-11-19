package com.fenixcode.papeleriarosita.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fenixcode.papeleriarosita.modelo.Pedido;

public interface PedidoCRUD extends JpaRepository<Pedido, Integer>{

}
