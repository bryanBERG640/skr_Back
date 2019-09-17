package com.skr.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skr.v1.entity.Cita;
import com.skr.v1.repository.RepositoryCita;

@RestController
@RequestMapping("/cita")
public class ControllerCita {
	
	private RepositoryCita repositoryCita;
	
	@Autowired
	public ControllerCita(RepositoryCita repositoryCita) {
		this.repositoryCita = repositoryCita;
	}
	
	@RequestMapping("/list")
	public List<Cita> citaList(){
		return repositoryCita.findAll();
	}
	
	@PostMapping(path = "/post")
	public @ResponseBody Cita insert(@RequestBody Cita agregar) {
		repositoryCita.save(agregar);
		return agregar;
	}
}
