package com.emilio.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emilio.modelos.Usuario;
import com.emilio.modelos.articulo;
import com.emilio.repositorios.RepositorioArticulo;
import com.emilio.repositorios.RepositorioUsuario;

@Service
public class ServicioFavoritos {

	@Autowired
	private RepositorioUsuario repositorioUsuario;

	@Autowired
	private RepositorioArticulo repositorioArticulo;

	public void agregarFavorito(Long idUsuario, Long idarticulo) {
		System.out.println("3");
		Usuario usuario = this.repositorioUsuario.findById(idUsuario).orElse(null);
		articulo articulo = this.repositorioArticulo.findById(idarticulo).orElse(null);
		System.out.println("4");
		usuario.getArticuloFavoritas().add(articulo);
		this.repositorioUsuario.save(usuario);
		System.out.println("5");
	}

	public void quitarFavorito(Long idUsuario, Long idarticulo) {
		Usuario usuario = this.repositorioUsuario.findById(idUsuario).orElse(null);
		articulo articulo = this.repositorioArticulo.findById(idarticulo).orElse(null);

		usuario.getArticuloFavoritas().remove(articulo);
		this.repositorioUsuario.save(usuario);
	}
}
