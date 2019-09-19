package com.skr.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skr.v1.entity.Sexo;
import com.skr.v1.repository.RepositorySexo;

@RestController
@RequestMapping("/sexo")
public class ControllerSexo {
	
	private RepositorySexo repositorySexo;
	
	@Autowired
	public ControllerSexo(RepositorySexo repositorySexo) {
		this.repositorySexo = repositorySexo;
	}
	
	@RequestMapping("/get")
	public List<Sexo> sexoList(){
		return repositorySexo.findAll();
	}
	@PostMapping(path = "/post")
	public @ResponseBody Sexo insert(@RequestBody Sexo agregar) {
		repositorySexo.save(agregar);
		return agregar;
	}
}
