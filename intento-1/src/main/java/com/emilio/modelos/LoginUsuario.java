package com.emilio.modelos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginUsuario {
	
	@NotBlank(message = "El campo es requerido.")
	@Email(message = "Debe ser un correo electrónico válido.")
	private String correo;

	@NotBlank(message = "El campo es requerido.")
	@Size(min = 8, message = "Debe contener al menos 8 caracteres.")
	private String password;

	public LoginUsuario() {
		super();
		this.correo = "";
		this.password = "";
	}

	public LoginUsuario(String correo, String password) {
		super();
		this.correo = correo;
		this.password = password;
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

	
}
