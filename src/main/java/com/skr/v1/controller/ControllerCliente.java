package com.skr.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skr.v1.entity.Cliente;
import com.skr.v1.repository.RepositoryCliente;

@RestController
@RequestMapping("/cliente")
public class ControllerCliente {
	
	private RepositoryCliente repoCliente;
	
	@Autowired
	public ControllerCliente(RepositoryCliente repoCliente) {
		this.repoCliente = repoCliente;
	}
	
	@RequestMapping("/all")
	public List<Cliente> clientesList() {
		return repoCliente.findAll();
	}
	
	@PostMapping("/add")
	public @ResponseBody Cliente insert(@RequestBody Cliente agr) {
		repoCliente.save(agr);
		return agr;
	}

}
