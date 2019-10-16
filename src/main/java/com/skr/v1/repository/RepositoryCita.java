package com.skr.v1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.skr.v1.entity.Cita;

@Repository
public interface RepositoryCita extends JpaRepository<Cita, Integer>{
	@Query(value="SELECT c FROM cita c where u.fecha = ?1", nativeQuery=true)
	List<Cita> findByFecha(String fecha);
}