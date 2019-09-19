package com.skr.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skr.v1.entity.Perfil;
import com.skr.v1.repository.RepositoryPerfil;

@RestController
@RequestMapping("/perfil")
public class ControllerPerfil {

	private RepositoryPerfil repo;
	
	@Autowired
	public ControllerPerfil(RepositoryPerfil repo){
		this.repo = repo;
	}
	
	@RequestMapping("/get")
	public List<Perfil> perfilList(){
		return repo.findAll();
	}
	
	@RequestMapping("/post")
	public @ResponseBody Perfil insert(@RequestBody Perfil agr) {
		repo.save(agr);
		return agr;
	}
	
}
