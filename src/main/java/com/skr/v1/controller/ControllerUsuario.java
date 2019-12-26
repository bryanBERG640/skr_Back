package com.skr.v1.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skr.v1.entity.Usuario;
import com.skr.v1.repository.RepositoryRoles;
import com.skr.v1.repository.RepositoryUser;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins="*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ControllerUsuario {

	@Autowired
	private RepositoryUser repositoryUser;
	private Usuario user;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired 
	private RepositoryRoles repositoryRoles;
	
	@Autowired
	public ControllerUsuario(RepositoryUser repositoryUser)
	{
		this.repositoryUser=repositoryUser;
	}
	
	@RequestMapping("/get")
	public List<Usuario> usuarioList()
	{
		return repositoryUser.findAll();
	}
	
	@GetMapping("/get/{usuario}")
	@ResponseBody Usuario getUsuario(@PathVariable String usuario)
	{
		Usuario user= repositoryUser.findByUsuario(usuario);
		return user;
	}
	
	@PostMapping("/{rol}/post")
	public Usuario addUser(@PathVariable(value="rol") int rol,
			@Valid @RequestBody Usuario usuario)
	{
		this.user=usuario;
		
		repositoryRoles.findById(rol).map(r->{
			this.user.setRol(r);
			return this.user;
		});
		
		String encodePassword=bCryptPasswordEncoder.encode(usuario.getpassword());
		this.user.setpassword(encodePassword);
		
		return repositoryUser.save(usuario);
	}
	
	@PutMapping("/{rol}/put/{id}")
	ResponseEntity<Usuario> updateUser(@PathVariable (value="rol") int rol,
			@Valid @RequestBody Usuario usuario)
	{
		this.user=usuario;
		
		repositoryRoles.findById(rol).map(r->{
			this.user.setRol(r);
			return this.user;
		});
		
		String encodePassword=bCryptPasswordEncoder.encode(usuario.getpassword());
		this.user.setpassword(encodePassword);
		
		Usuario result= repositoryUser.save(usuario);
		return ResponseEntity.ok().body(result);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Usuario> eliminar(@PathVariable int id)
	{
		repositoryUser.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}
