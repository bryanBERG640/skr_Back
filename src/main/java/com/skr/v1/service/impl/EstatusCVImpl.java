package com.skr.v1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.skr.v1.entity.EstatusCV;
import com.skr.v1.repository.RepositoryEstatusCV;
import com.skr.v1.service.EstatusCVService;

public class EstatusCVImpl implements EstatusCVService{

	private RepositoryEstatusCV repositoryEstatusCV;
	
	@Autowired
	public EstatusCVImpl(RepositoryEstatusCV repositoryEstatusCV) {
		this.repositoryEstatusCV = repositoryEstatusCV;
	}
	
	@Autowired
	public List<EstatusCV> estatusCVList(){
		return repositoryEstatusCV.findAll();
	}
}
