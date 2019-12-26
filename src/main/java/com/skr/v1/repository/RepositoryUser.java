package com.skr.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skr.v1.entity.Usuario;

@Repository
public interface RepositoryUser  extends JpaRepository<Usuario, Integer>{

	Usuario findByUsuario(String usuario);
	
	Usuario deleteByUsuario(String usuario);
}
