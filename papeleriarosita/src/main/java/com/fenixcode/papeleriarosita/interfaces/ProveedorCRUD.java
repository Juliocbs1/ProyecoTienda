package com.fenixcode.papeleriarosita.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fenixcode.papeleriarosita.DTO.ProveedorDTO;
import com.fenixcode.papeleriarosita.modelo.Proveedor;

@Repository
public interface ProveedorCRUD extends JpaRepository<Proveedor, Long>{

}
