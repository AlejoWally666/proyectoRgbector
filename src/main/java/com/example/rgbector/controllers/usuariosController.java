package com.example.rgbector.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.rgbector.models.entities.tipoUsuario;
import com.example.rgbector.models.entities.usuarios;
import com.example.rgbector.models.services.ITipoUsuarioService;
import com.example.rgbector.models.services.IUsuariosService;

@Controller
@RequestMapping(value = "/usuarios")
public class usuariosController {

	// Todas las peticiones que gestiona este controlador
	// empiezan por /usuarios, Ejemplo: https://localhost:8080/usuarios/create

	@Autowired
	private IUsuariosService srvUsuarios;
	
	@Autowired
	private ITipoUsuarioService srvtipoUsuario;

	// Cada metodo en el controlador gestiona una peticion al backend
	// a traves de una URL (Puede ser -> 1. Escrita en el navegador,
	// 2. Puede ser Hyperlink, 3. Puede ser un action de un Form)

	@GetMapping(value = "/create") // https://localhost:8080/usuarios/create
	public String create(Model model) {
		usuarios usuarios = new usuarios();
		model.addAttribute("title", "Registro de un nuevo Usuario");
		model.addAttribute("usuarios", usuarios); // similar al ViewBag
		List<tipoUsuario> tipoUsuario = srvtipoUsuario.findAll();
		model.addAttribute("tipoUsuario",tipoUsuario);
		return "usuarios/form"; // la ubicacion de la vista
	}

	@GetMapping(value = "/retrieve/{id}")
	public String retrieve(@PathVariable(value = "id") Long id, Model model) {
		usuarios usuarios = srvUsuarios.findById(id);
		model.addAttribute("usuarios", usuarios);
		return "usuarios/card";
	}

	@GetMapping(value = "/update/{id}")
	public String update(@PathVariable(value = "id") Long id, Model model) {
		usuarios usuarios = srvUsuarios.findById(id);
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("title", "Actualizando el registro de " + usuarios.toString());
		List<tipoUsuario> tipoUsuario = srvtipoUsuario.findAll();
		model.addAttribute("tipoUsuario",tipoUsuario);
		return "usuarios/form";
	}

	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable(value = "id") Long id, Model model) {
		srvUsuarios.delete(id);
		return "redirect:/usuarios/list";
	}

	@GetMapping(value = "/list")
	public String list(Model model) {
		List<usuarios> usuarios = srvUsuarios.findAll();
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("title", "Listado de usuarios");
		return "usuarios/list";
	}

	@PostMapping(value = "/save") // https://localhost:8080/usuarios/save
	public String save(usuarios usuarios, Model model) {
		srvUsuarios.save(usuarios);
		return "redirect:/usuarios/list";
	}
}
