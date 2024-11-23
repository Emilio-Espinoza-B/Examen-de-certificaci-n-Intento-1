package com.emilio.repositorios;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.emilio.modelos.Usuario;

@Repository
public interface RepositorioUsuario extends CrudRepository<Usuario, Long>{
	Optional<Usuario> findByCorreo(String correo);
}
