package com.skr.v1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.skr.v1.entity.PostulanteComplemento;
import com.skr.v1.repository.RepositoryPostulanteComplemento;

public class PostulanteComplementoImpl {

private RepositoryPostulanteComplemento repositoryPostulanteComplemento;
	
	@Autowired
	public PostulanteComplementoImpl(RepositoryPostulanteComplemento repositoryPostulanteComplemento) {
		this.repositoryPostulanteComplemento = repositoryPostulanteComplemento;
	}
	
	@Autowired
	public List<PostulanteComplemento> postulanteComplementoList(){
		return repositoryPostulanteComplemento.findAll();
	}
}
