package com.skr.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skr.v1.entity.TipoEntrevista;
import com.skr.v1.repository.RepositoryTipoEntrevista;

@RestController
@RequestMapping("/tipoEntrevista")
public class ControllerTipoEntrevista {

	private RepositoryTipoEntrevista repo;
	
	@Autowired
	public ControllerTipoEntrevista(RepositoryTipoEntrevista repo) {
		this.repo = repo;
	}
	
	@RequestMapping("/get")
	public List<TipoEntrevista> tipoEntrevistaList(){
		return repo.findAll();
	}
	
	@RequestMapping("/post")
	public @ResponseBody TipoEntrevista insert(@RequestBody TipoEntrevista agr) {
		repo.save(agr);
		return agr;
	}
	
}
