package com.emilio.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.emilio.modelos.LoginUsuario;
import com.emilio.modelos.Usuario;
import com.emilio.servicios.ServicioUsuario;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorUsuario {

	@Autowired
	private ServicioUsuario servicio;

	@GetMapping("/") // form de login
	public String formLogin(Model modelo) {
		modelo.addAttribute("loginUsuario", new LoginUsuario());
		return "login";
	}

	@GetMapping("/registro") // form de registro
	public String formRegistro(Model modelo) {
		modelo.addAttribute("usuario", new Usuario());
		return "register";
	}

	@GetMapping("/logout") // cierre de sesión
	public String logOut(HttpSession sesion) {
		sesion.invalidate();
		return "redirect:/";
	}

	@PostMapping("/login") // procesar info del login
	public String logIn(@Valid @ModelAttribute("loginUsuario") LoginUsuario loginUsuario, BindingResult validaciones,
			Model modelo, HttpSession sesion) {
		this.servicio.validarLogin(validaciones, loginUsuario);
		if (validaciones.hasErrors()) {
			return "login";
		}
		Usuario usuario = this.servicio.obtenerPorEmail(loginUsuario.getCorreo());
		sesion.setAttribute("nombreCompleto", usuario.getNombre() + " " + usuario.getApellido());
		sesion.setAttribute("idUsuario", usuario.getId());
		return "redirect:/articulos";
	}

	@PostMapping("/register") // procesar info del registro
	public String register(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult validaciones, Model modelo,
			HttpSession sesion) {
		this.servicio.validarRegistro(validaciones, usuario);
		if (validaciones.hasErrors()) {
			return "register";
		}
		Usuario usuario2 = this.servicio.crear(usuario);
		sesion.setAttribute("nombreCompleto", usuario2.getNombre() + " " + usuario2.getApellido());
		sesion.setAttribute("idUsuario", usuario2.getId());
		return "redirect:/articulos";
	}
}
