package com.skr.v1.controller;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.skr.v1.entity.Seccion;
import com.skr.v1.repository.RepositoryExamen;
import com.skr.v1.repository.RepositorySeccion;

@RestController
@RequestMapping("/seccion")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT})
public class ControllerSeccion {
	
	private final Logger log = LoggerFactory.getLogger(ControllerSeccion.class);	
	
	@Autowired
	private RepositorySeccion repositorySeccion;
	private Seccion seccionN;
	
	@Autowired
	private RepositoryExamen repositoryExamen;

	@Autowired
	public ControllerSeccion(RepositorySeccion repositorySeccion) {
		this.repositorySeccion = repositorySeccion;
	}
	
	@GetMapping("/get")
    Collection<Seccion> groups() {
        return repositorySeccion.findAll();
    }
	
	@GetMapping("/get/{id}")
    ResponseEntity<?> getSeccion(@PathVariable int id) {
        Optional<Seccion> seccion = repositorySeccion.findById(id);
        return seccion.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }	
	
	@PostMapping("/{examen}/post")
	public Seccion addSeccion(@PathVariable (value = "examen") int examen,
									  @Valid @RequestBody Seccion seccion)
	{
		log.info("Request to insert group: {}", seccion);
		
		this.seccionN = seccion;
		repositoryExamen.findById(examen).map(exam ->{
			this.seccionN.setExamen(exam);
			return this.seccionN;
		});
		return repositorySeccion.save(seccion);
	}
	
	@PutMapping("/{examen}/put/{id}")
    ResponseEntity<Seccion> updateSeccion(@PathVariable (value= "examen") int examen,
    											@Valid @RequestBody Seccion seccion) {
        log.info("Request to update group: {}", seccion);
        this.seccionN = seccion;
        repositoryExamen.findById(examen).map(exam -> {
        	this.seccionN.setExamen(exam);
        	return this.seccionN;
        });
        Seccion result = repositorySeccion.save(seccion);
        return ResponseEntity.ok().body(result);
    }
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Seccion> eliminar(@PathVariable int id)
	{
		repositorySeccion.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
