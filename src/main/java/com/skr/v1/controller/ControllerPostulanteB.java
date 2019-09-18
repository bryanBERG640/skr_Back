package com.skr.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skr.v1.entity.PostulanteB;
import com.skr.v1.repository.RepositoryPostulanteB;

@RestController
@RequestMapping("/PostulanteB")
public class ControllerPostulanteB {

	private RepositoryPostulanteB repositoryPostulanteB;
	
	@Autowired
	public ControllerPostulanteB(RepositoryPostulanteB repositoryPostulanteB)
	{
		this.repositoryPostulanteB=repositoryPostulanteB;
	}
	
	@RequestMapping("/list")
	public List<PostulanteB> postulantebList()
	{
		return repositoryPostulanteB.findAll();
	}
	
	@PostMapping(path="/post")
	public @ResponseBody PostulanteB insert(@RequestBody PostulanteB agregar)
	{
		repositoryPostulanteB.save(agregar);
		return agregar;
	}
}
