package com.emilio.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.emilio.modelos.articulo;

@Repository
public interface RepositorioArticulo extends CrudRepository<articulo, Long>{

}
