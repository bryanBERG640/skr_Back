package com.skr.v1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.skr.v1.entity.PostulanteB;
import com.skr.v1.repository.RepositoryPostulanteB;
import com.skr.v1.service.PostulanteBService;

public class PostulanteBImpl implements PostulanteBService{

	
	private RepositoryPostulanteB repositoryPostulanteB;
	
	@Autowired
	public PostulanteBImpl(RepositoryPostulanteB repositoryPostulanteB)
	{
		this.repositoryPostulanteB=repositoryPostulanteB;
	}
	
	@Autowired
	public List<PostulanteB> postulantebList()
	{
		return repositoryPostulanteB.findAll();
	}

}
