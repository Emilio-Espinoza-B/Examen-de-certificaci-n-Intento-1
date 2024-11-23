package com.emilio.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emilio.modelos.articulo;
import com.emilio.repositorios.RepositorioArticulo;

@Service
public class ServicioArticulo {
	
	@Autowired
	private RepositorioArticulo repositorio;
	// CRUD

		public articulo crear(articulo articulo) {
			return this.repositorio.save(articulo);
		}

		public articulo obtenerPorId(Long id) {
			return this.repositorio.findById(id).orElse(null);
		}

		public List<articulo> obtenerTodas() {
			return (List<articulo>) this.repositorio.findAll();
		}

		public articulo actualizar(articulo articulo) {
			return this.repositorio.save(articulo);
		}

		public void eliminarPorId(Long id) {
			this.repositorio.deleteById(id);
		}
}
