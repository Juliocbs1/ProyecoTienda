package com.fenixcode.papeleriarosita.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
import org.springframework.stereotype.Repository;

import com.fenixcode.papeleriarosita.modelo.Usuario;

@Repository
public interface UsuarioCRUD extends JpaRepository<Usuario,String>{

}
