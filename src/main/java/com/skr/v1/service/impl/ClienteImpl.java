package com.skr.v1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.skr.v1.entity.Cliente;
import com.skr.v1.repository.RepositoryCliente;
import com.skr.v1.service.ClienteService;

public class ClienteImpl implements ClienteService {
	
	private RepositoryCliente repoCliente;
	
	@Autowired
	public ClienteImpl(RepositoryCliente repoCliente) {
		this.repoCliente = repoCliente;
	}
	
	@Autowired
	public List<Cliente> clientesList() {
		return repoCliente.findAll();
	}
}
