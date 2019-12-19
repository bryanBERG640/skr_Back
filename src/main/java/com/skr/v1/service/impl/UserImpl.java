package com.skr.v1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.skr.v1.entity.Usuario;
import com.skr.v1.repository.RepositoryUser;


public class UserImpl {
	
	private RepositoryUser repo;
	
	@Autowired
	public UserImpl(RepositoryUser repo)
	{
		this.repo=repo;
	}
	
	@Autowired
	public List<Usuario> usuarioList()
	{
		return repo.findAll();
	}
	
}
