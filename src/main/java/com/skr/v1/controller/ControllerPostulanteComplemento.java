package com.skr.v1.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skr.v1.entity.PostulanteComplemento;
import com.skr.v1.repository.RepositoryCarrera;
import com.skr.v1.repository.RepositoryEscuela;
import com.skr.v1.repository.RepositoryEstatusAprobacion;
import com.skr.v1.repository.RepositoryEstatusCV;
import com.skr.v1.repository.RepositoryEstatusTitulacion;
import com.skr.v1.repository.RepositoryPostulanteB;
import com.skr.v1.repository.RepositoryPostulanteComplemento;
import com.skr.v1.repository.RepositorySexo;

@RestController
@RequestMapping("/postulanteComplemento")
public class ControllerPostulanteComplemento {

	@Autowired
	private RepositoryPostulanteComplemento repositoryPostulanteComplemento;
	@Autowired
	private RepositoryPostulanteB repositoryPostulanteB;
	@Autowired
	private RepositoryEscuela repositoryEscuela;
	@Autowired
	private RepositoryCarrera repositoryCarrera;
	@Autowired
	private RepositoryEstatusTitulacion repositoryEstatusTitulacion;
	@Autowired
	private RepositoryEstatusCV repositoryEstatusCV;
	@Autowired
	private RepositoryEstatusAprobacion repositoryEstatusAprobacion;
	@Autowired
	private RepositorySexo repositorySexo;
	private PostulanteComplemento postulanteComplemento;
	
	@Autowired
	public ControllerPostulanteComplemento(RepositoryPostulanteComplemento repositoryPostulanteComplemento) {
		this.repositoryPostulanteComplemento = repositoryPostulanteComplemento;
	}
	
	@RequestMapping("/get")
	public List<PostulanteComplemento> postulanteComplementoList(){
		return repositoryPostulanteComplemento.findAll();
	}
	
	@GetMapping("/get/{id}")
    ResponseEntity<?> getPostulanteB(@PathVariable int id) {
        Optional<PostulanteComplemento> postulanteComplemento = repositoryPostulanteComplemento.findById(id);
        return postulanteComplemento.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }	
	
	@PostMapping(path="/{postulanteB}/{escuela}/{titulacion}/{carrera}/{sexo}/{cv}/{aprobacion}/post")
	public PostulanteComplemento addPostulanteB(@PathVariable (value = "postulanteB") int postulanteB,
									  @PathVariable (value = "escuela") int escuela,
									  @PathVariable (value = "titulacion") int titulacion,
									  @PathVariable (value = "carrera") int carrera,
									  @PathVariable (value = "sexo") int sexo,
									  @PathVariable (value = "cv") int cv,
									  @PathVariable (value = "aprobacion") int aprobacion,
									  @Valid @RequestBody PostulanteComplemento postulantecomplemento)
	{
		
		this.postulanteComplemento = postulantecomplemento;
		repositoryPostulanteB.findById(postulanteB).map(postulante ->{
			this.postulanteComplemento.setPostulanteb(postulante);
			return this.postulanteComplemento;
		});
		repositoryEscuela.findById(escuela).map(school ->{
			this.postulanteComplemento.setEscuela(school);
			return this.postulanteComplemento; 
		});
		repositoryEstatusTitulacion.findById(titulacion).map(titulado ->{
			this.postulanteComplemento.setEstatustitulacion(titulado);
			return this.postulanteComplemento;
		});
		repositoryCarrera.findById(carrera).map(carrer ->{
			this.postulanteComplemento.setCarrera(carrer);
			return this.postulanteComplemento;
		});
		repositorySexo.findById(sexo).map(sex ->{
			this.postulanteComplemento.setSexo(sex);
			return this.postulanteComplemento;
		});
		repositoryEstatusCV.findById(cv).map(estcv ->{
			this.postulanteComplemento.setEstatuscv(estcv);
			return this.postulanteComplemento;
		});
		repositoryEstatusAprobacion.findById(aprobacion).map(aprobado ->{
			this.postulanteComplemento.setEstatusprobacion(aprobado);
			return this.postulanteComplemento;
		});
		return repositoryPostulanteComplemento.save(postulantecomplemento);
	}
	
	@PutMapping(path="/{postulanteB}/{escuela}/{titulacion}/{carrera}/{sexo}/{cv}/{aprobacion}/post/{id}")
	ResponseEntity<PostulanteComplemento> updatePostulanteB(@PathVariable (value = "postulanteB") int postulanteB,
									  @PathVariable (value = "escuela") int escuela,
									  @PathVariable (value = "titulacion") int titulacion,
									  @PathVariable (value = "carrera") int carrera,
									  @PathVariable (value = "sexo") int sexo,
									  @PathVariable (value = "cv") int cv,
									  @PathVariable (value = "aprobacion") int aprobacion,
									  @Valid @RequestBody PostulanteComplemento postulantecomplemento)
	{
		
		this.postulanteComplemento = postulantecomplemento;
		repositoryPostulanteB.findById(postulanteB).map(postulante ->{
			this.postulanteComplemento.setPostulanteb(postulante);
			return this.postulanteComplemento;
		});
		repositoryEscuela.findById(escuela).map(school ->{
			this.postulanteComplemento.setEscuela(school);
			return this.postulanteComplemento;
		});
		repositoryEstatusTitulacion.findById(titulacion).map(titulado ->{
			this.postulanteComplemento.setEstatustitulacion(titulado);
			return this.postulanteComplemento;
		});
		repositoryCarrera.findById(carrera).map(carrer ->{
			this.postulanteComplemento.setCarrera(carrer);
			return this.postulanteComplemento;
		});
		repositorySexo.findById(sexo).map(sex ->{
			this.postulanteComplemento.setSexo(sex);
			return this.postulanteComplemento;
		});
		repositoryEstatusCV.findById(cv).map(estcv ->{
			this.postulanteComplemento.setEstatuscv(estcv);
			return this.postulanteComplemento;
		});
		repositoryEstatusAprobacion.findById(aprobacion).map(aprobado ->{
			this.postulanteComplemento.setEstatusprobacion(aprobado);
			return this.postulanteComplemento;
		});
		PostulanteComplemento result = repositoryPostulanteComplemento.save(postulantecomplemento);
		return ResponseEntity.ok().body(result);
	}
}