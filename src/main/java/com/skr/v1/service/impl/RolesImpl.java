package com.skr.v1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.skr.v1.entity.Roles;
import com.skr.v1.repository.RepositoryRoles;

public class RolesImpl {

	private RepositoryRoles repo;
	
	@Autowired
	public RolesImpl (RepositoryRoles repo)
	{
		this.repo=repo;
	}
	
	@Autowired
	public List<Roles> rolesList()
	{
		return repo.findAll();
	}
}
