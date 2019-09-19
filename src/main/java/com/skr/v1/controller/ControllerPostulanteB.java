package com.skr.v1.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import com.skr.v1.entity.EstatusPostulante;
import com.skr.v1.entity.PostulanteB;
import com.skr.v1.repository.RepositoryEstatusPostulante;
import com.skr.v1.repository.RepositoryPerfil;
import com.skr.v1.repository.RepositoryPostulanteB;
//import com.skr.v1.service.PostulanteBService;

@RestController
@RequestMapping("/postulanteB")
public class ControllerPostulanteB {
	
	@Autowired
	private RepositoryPostulanteB repositoryPostulanteB;
	//@Autowired
	//private PostulanteBService postulanteBService;
	@Autowired
	private RepositoryPerfil repositoryPerfil;
	@Autowired 
	private RepositoryEstatusPostulante repositoryEstatusPostulante;
	private PostulanteB postulanteB;
	
	@Autowired
	public ControllerPostulanteB(RepositoryPostulanteB repositoryPostulanteB)
	{
		this.repositoryPostulanteB=repositoryPostulanteB;
	}
	
	@RequestMapping("/get")
	public List<PostulanteB> postulantebList()
	{
		return repositoryPostulanteB.findAll();
	}
	
	@PostMapping(path="/{estatuspostulante}/{perfil}/post")
	public PostulanteB addPostulanteB(@PathVariable (value = "estatuspostulante") int estatuspostulante,
									  @PathVariable (value = "perfil") int perfil,
									  @Valid @RequestBody PostulanteB postulanteb)
	{
		
		this.postulanteB = postulanteb;
		repositoryEstatusPostulante.findById(estatuspostulante).map(estatuspostulant ->{
			this.postulanteB.setEstatuspostulante(estatuspostulant);
			return this.postulanteB;
		});
		repositoryPerfil.findById(perfil).map(perfi -> {
			this.postulanteB.setPerfil(perfi);
			return this.postulanteB;
		});
		return repositoryPostulanteB.save(postulanteb);
	}
}
