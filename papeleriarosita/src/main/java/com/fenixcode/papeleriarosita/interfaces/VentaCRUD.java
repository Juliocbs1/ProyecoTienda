package com.fenixcode.papeleriarosita.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fenixcode.papeleriarosita.modelo.Venta;

public interface VentaCRUD extends JpaRepository<Venta, Integer>{

}
