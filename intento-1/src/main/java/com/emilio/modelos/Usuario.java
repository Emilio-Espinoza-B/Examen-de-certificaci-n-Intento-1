package com.emilio.modelos;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
public class Usuario {

	//registro y login
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "Por favor proporciona tu nombre")
	@Size(min = 3, message = "Debe contener al menos 3 caracteres")
	private String nombre;
	
	@NotBlank(message = "Por favor proporciona tu nombre")
	@Size(min = 3, message = "Debe contener al menos 3 caracteres")
	private String apellido;
	
	@Column(unique = true)
	@NotBlank(message = "Por favor proporciona tu correo")
	@Email(message = "Debe ser un correo electrónico válido.")
	private String correo;
	
	@NotBlank(message = "El campo es requerido.")
	@Size(min = 8, message = "Debe contener al menos 8 caracteres.")
	private String password;

	@Transient
	private String confirmarPassword;
	
	@OneToMany(mappedBy = "creador")
	private List<articulo> articulos;
	
	@ManyToMany
	@JoinTable(name = "favoritos", joinColumns = @JoinColumn(name = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_articulo"))
	private List<articulo> articuloFavoritas;

	public Usuario() {
		super();
		this.id = 0l;
		this.nombre = "";
		this.apellido = "";
		this.correo = "";
		this.password = "";
		this.confirmarPassword = "";
		this.articulos = null;
	}

	public Usuario(Long id, String nombre, String apellido, String correo, String password, String confirmarPassword, List<articulo> articulos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.password = password;
		this.confirmarPassword = confirmarPassword;
		this.articulos = articulos;
	}

	//getters y setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmarPassword() {
		return confirmarPassword;
	}

	public void setConfirmarPassword(String confirmarPassword) {
		this.confirmarPassword = confirmarPassword;
	}

	public List<articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<articulo> articulos) {
		this.articulos = articulos;
	}

	public List<articulo> getArticuloFavoritas() {
		return articuloFavoritas;
	}

	public void setArticuloFavoritas(List<articulo> articuloFavoritas) {
		this.articuloFavoritas = articuloFavoritas;
	}
	
	
}
