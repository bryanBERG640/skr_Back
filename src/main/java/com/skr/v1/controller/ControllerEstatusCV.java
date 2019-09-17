package com.skr.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skr.v1.entity.EstatusCV;
import com.skr.v1.repository.RepositoryEstatusCV;
@RestController
@RequestMapping("/estatuscv")
public class ControllerEstatusCV {

	private RepositoryEstatusCV repositoryEstatusCV;
	
	@Autowired
	public ControllerEstatusCV(RepositoryEstatusCV repositoryEstatusCV) {
		this.repositoryEstatusCV = repositoryEstatusCV;
	}
	
	@RequestMapping("/list")
	public List<EstatusCV> estatusCVList(){
		return repositoryEstatusCV.findAll();
	}
}
