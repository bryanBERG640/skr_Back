package com.skr.v1.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.skr.v1.entity.PostulanteB;
import com.skr.v1.repository.RepositoryEstatusPostulante;
import com.skr.v1.repository.RepositoryPerfil;
import com.skr.v1.repository.RepositoryPostulanteB;

@RestController
@RequestMapping("/postulanteB")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT})
public class ControllerPostulanteB {
	
	private final Logger log = LoggerFactory.getLogger(ControllerSeccion.class);
	
	@Autowired
	private RepositoryPostulanteB repositoryPostulanteB;
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
	public List<PostulanteB> postulantebList(){
		return repositoryPostulanteB.findAll();
	}
	
	@GetMapping("/get/{id}")
    ResponseEntity<?> getPostulanteB(@PathVariable int id) {
        Optional<PostulanteB> postulanteB = repositoryPostulanteB.findById(id);
        return postulanteB.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
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
	
	@PutMapping("/{estatuspostulante}/{perfil}/put/{id}")
    ResponseEntity<PostulanteB> updatePostulanteB(@PathVariable (value= "estatuspostulante") int estatuspostulante,
    											  @PathVariable (value= "perfil") int perfil,
    											  @Valid @RequestBody PostulanteB postulanteB) {
        log.info("Request to update group: {}", postulanteB);
        this.postulanteB = postulanteB;
        repositoryEstatusPostulante.findById(estatuspostulante).map(estatus -> {
        	this.postulanteB.setEstatuspostulante(estatus);
        	return this.postulanteB;
        });
        repositoryPerfil.findById(perfil).map(perf -> {
        	this.postulanteB.setPerfil(perf);
        	return this.postulanteB;
        });
        PostulanteB result = repositoryPostulanteB.save(postulanteB);
        return ResponseEntity.ok().body(result);
    }
	
}
