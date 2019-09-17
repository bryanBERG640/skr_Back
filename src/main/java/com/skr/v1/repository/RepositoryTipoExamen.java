package com.skr.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skr.v1.entity.TipoExamen;

@Repository
public interface RepositoryTipoExamen extends JpaRepository<TipoExamen, Integer> {
	
}
