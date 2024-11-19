package com.fenixcode.papeleriarosita.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fenixcode.papeleriarosita.DTO.ClienteDTO;
import com.fenixcode.papeleriarosita.modelo.Cliente;
@Repository
public interface ClienteCRUD extends JpaRepository<Cliente, Long> {

}
