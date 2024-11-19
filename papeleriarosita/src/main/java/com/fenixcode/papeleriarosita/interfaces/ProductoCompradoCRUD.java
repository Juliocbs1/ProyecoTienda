package com.fenixcode.papeleriarosita.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fenixcode.papeleriarosita.modelo.ProductoComprado;

@Repository
public interface ProductoCompradoCRUD extends JpaRepository<ProductoComprado, Integer>{

}
