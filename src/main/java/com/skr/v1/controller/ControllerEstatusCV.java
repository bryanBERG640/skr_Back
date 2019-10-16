package com.skr.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@RequestMapping("/get")
	public List<EstatusCV> estatusCVList(){
		return repositoryEstatusCV.findAll();
	}
	
	@PostMapping(path = "/post")
	public @ResponseBody EstatusCV insert(@RequestBody EstatusCV agregar) {
		repositoryEstatusCV.save(agregar);
		return agregar;
	}
}
