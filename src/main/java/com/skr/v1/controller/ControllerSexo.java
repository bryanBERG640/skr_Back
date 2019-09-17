package com.skr.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@RequestMapping("/list")
	public List<Sexo> sexoList(){
		return repositorySexo.findAll();
	}
}
