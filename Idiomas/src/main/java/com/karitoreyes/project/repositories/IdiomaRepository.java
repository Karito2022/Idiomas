package com.karitoreyes.project.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.karitoreyes.project.models.Idioma;

@Repository
public interface IdiomaRepository extends CrudRepository<Idioma, Long> {
	List<Idioma> findAll();
}