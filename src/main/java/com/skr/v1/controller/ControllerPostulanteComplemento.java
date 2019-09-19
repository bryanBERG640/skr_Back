package com.skr.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skr.v1.entity.PostulanteComplemento;
import com.skr.v1.repository.RepositoryPostulanteComplemento;

@RestController
@RequestMapping("/postulanteComplemento")
public class ControllerPostulanteComplemento {

	private RepositoryPostulanteComplemento repositoryPostulanteComplemento;
	
	@Autowired
	public ControllerPostulanteComplemento(RepositoryPostulanteComplemento repositoryPostulanteComplemento) {
		this.repositoryPostulanteComplemento = repositoryPostulanteComplemento;
	}
	
	@RequestMapping("/get")
	public List<PostulanteComplemento> postulanteComplementoList(){
		return repositoryPostulanteComplemento.findAll();
	}
	
	@PostMapping(path = "/post")
	public @ResponseBody PostulanteComplemento insert(@RequestBody PostulanteComplemento agregar) {
		repositoryPostulanteComplemento.save(agregar);
		return agregar;
	}
}