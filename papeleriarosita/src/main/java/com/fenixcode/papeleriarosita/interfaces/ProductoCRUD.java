package com.fenixcode.papeleriarosita.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fenixcode.papeleriarosita.modelo.Producto;
@Repository
public interface ProductoCRUD extends JpaRepository<Producto,Integer >{

}
