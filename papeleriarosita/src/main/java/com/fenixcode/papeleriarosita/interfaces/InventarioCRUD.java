package com.fenixcode.papeleriarosita.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fenixcode.papeleriarosita.modelo.Inventario;

@Repository
public interface InventarioCRUD extends JpaRepository<Inventario,Integer> {

}
