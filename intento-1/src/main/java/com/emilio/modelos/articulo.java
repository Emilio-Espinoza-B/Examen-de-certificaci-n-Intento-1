package com.emilio.modelos;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "articulos")
public class articulo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Por favor proporciona tu titulo.")
	@Size(min = 3, message = "Debe contener al menos 3 caracteres.")
	private String titulo;
	
	@Column(unique = true)
	@NotBlank(message = "Por favor proporciona tu descripcion.")
	@Size(min = 10, message = "Debe contener al menos 10 caracteres.")
	private String descripcion;
	
	@NotBlank(message = "Por favor proporciona tu categoria.")
	@Size(min = 5, message = "Debe contener al menos 5 caracteres.")
	private String categoria;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario creador;
	
	@ManyToMany
	@JoinTable(name = "favoritos", joinColumns = @JoinColumn(name = "id_articulo"), inverseJoinColumns = @JoinColumn(name = "id_usuario"))
	@Transient
	private List<Usuario> usuariosFavoritos;

	public articulo() {
		super();
		this.id = 0l;
		this.titulo = "";
		this.descripcion = "";
		this.categoria = "";
		this.creador = null;
	}
	
	public articulo(Long id, String titulo, String descripcion, String categoria, Usuario creador) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.creador = creador;
	}

//getters y setters

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public String getCategoria() {
		return categoria;
	}



	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}



	public Usuario getCreador() {
		return creador;
	}



	public void setCreador(Usuario creador) {
		this.creador = creador;
	}



	public List<Usuario> getUsuariosFavoritos() {
		return usuariosFavoritos;
	}



	public void setUsuariosFavoritos(List<Usuario> usuariosFavoritos) {
		this.usuariosFavoritos = usuariosFavoritos;
	}

	
}
