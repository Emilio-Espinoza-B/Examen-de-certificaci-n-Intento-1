package com.emilio.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.emilio.modelos.articulo;
import com.emilio.servicios.ServicioArticulo;
import com.emilio.servicios.ServicioFavoritos;
import com.emilio.servicios.ServicioUsuario;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;



@Controller
public class ControladorArticulo {

	@Autowired
	private ServicioArticulo servicio;
	
	@Autowired
	private ServicioFavoritos servicioFavorito;

	@Autowired
	private ServicioUsuario servicioUsuario;

	@GetMapping("/articulos") //todos los articulos
	public String mostrarArticulos(HttpSession sesion, Model model) {
		Long idUsuario = (Long) sesion.getAttribute("idUsuario");
		if (idUsuario == null) {
			return "redirect:/";
		}
		model.addAttribute("articulos",this.servicio.obtenerTodas());
		model.addAttribute("favsUsuario",this.servicioUsuario.obtenerPorId(idUsuario).getArticuloFavoritas());
		return "articulos";
	}
	
	@GetMapping("/form/agregar") //creacion
	public String agregar(HttpSession sesion, Model modelo) {
		if (sesion.getAttribute("nombreCompleto") == null) {
			return "redirect:/";
		}
		modelo.addAttribute("articulo", new articulo());
		return "agregar";
	}
	
	@GetMapping("/form/editar/{id}") // vista de form de edición
	public String editar(@PathVariable("id") Long id, HttpSession sesion, Model modelo, @ModelAttribute("articulo") articulo articulo) {
		if (sesion.getAttribute("nombreCompleto") == null) {
			return "redirect:/";
		}
		modelo.addAttribute("articulo", this.servicio.obtenerPorId(id));
		return "editar";
	}
	
	@PostMapping("/guardar") // procesar form de creación
	public String guardar(HttpSession sesion, @Valid @ModelAttribute("articulo") articulo articulo, BindingResult validaciones) {
		if (sesion.getAttribute("nombreCompleto") == null) {
			return "redirect:/";
		}
		if (validaciones.hasErrors()) {
			return "agregar";
		}
		this.servicio.crear(articulo);
		return "redirect:/articulos";
	}
	
	@PutMapping("/actualizar/{id}") // procesar form de edición
	public String actualizar(@PathVariable("id") Long id, HttpSession sesion, @Valid @ModelAttribute("articulo") articulo articulo, BindingResult validaciones) {
		if (sesion.getAttribute("nombreCompleto") == null) {
			return "redirect:/";
		}
		if (validaciones.hasErrors()) {
			return "editar";
		}
		this.servicio.actualizar(articulo);
		return "redirect:/articulos";
	}
	
	@DeleteMapping("/eliminar/{id}") // eliminar una frase
	public String eliminar(@PathVariable("id") Long id, HttpSession sesion) {
		if (sesion.getAttribute("nombreCompleto") == null) {
			return "redirect:/";
		}
		this.servicio.eliminarPorId(id);
		return "redirect:/articulos";
	}
	
	@GetMapping("/detalle/{id}") // vista de detalle
	public String detalle(@PathVariable("id") Long id, HttpSession sesion, Model modelo) {
		if (sesion.getAttribute("nombreCompleto") == null) {
			return "redirect:/";
		}
		modelo.addAttribute("articulo", this.servicio.obtenerPorId(id));
		return "detalle";
	}
	
	@GetMapping("/favoritos") // vista de favoritos
	public String vistaFavoritos(HttpSession sesion, Model modelo) {
		Long idUsuario = (Long) sesion.getAttribute("idUsuario");
		if (idUsuario == null) {
			return "redirect:/";
		}
		modelo.addAttribute("favsUsuario", this.servicioUsuario.obtenerPorId(idUsuario).getArticuloFavoritas());
		return "favoritos";
	}

	@PostMapping("/agregarFav/{id}") // acción de añadir fav
	public String agregarFavorito(HttpSession sesion, @PathVariable("id") Long idarticulo) {
		Long idUsuario = (Long) sesion.getAttribute("idUsuario");
		if (idUsuario == null) {
			return "redirect:/";
		}
		System.out.println("1");
		this.servicioFavorito.agregarFavorito(idUsuario, idarticulo);
		System.out.println("2");
		return "redirect:/articulos";
	}
	
	@DeleteMapping("/quitarFav/{id}") // acción de borrar fav
	public String quitarFavorito(HttpSession sesion, @PathVariable("id") Long idarticulo) {
		Long idUsuario = (Long) sesion.getAttribute("idUsuario");
		if (idUsuario == null) {
			return "redirect:/";
		}
		this.servicioFavorito.quitarFavorito(idUsuario, idarticulo);
		return "redirect:/articulos";
	}
}
