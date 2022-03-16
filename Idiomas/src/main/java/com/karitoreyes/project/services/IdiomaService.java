package com.karitoreyes.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.karitoreyes.project.models.Idioma;
import com.karitoreyes.project.repositories.IdiomaRepository;

@Service
public class IdiomaService {

    private final IdiomaRepository idiomaRepository;
    
    public IdiomaService(IdiomaRepository idiomaRepository) {
        this.idiomaRepository = idiomaRepository;
    }
    
    public List<Idioma> allIdiomas() {
        return idiomaRepository.findAll();
    }
    
    public Idioma createIdioma(Idioma idioma) {
        return idiomaRepository.save(idioma);
    }
    
    public Idioma finIdioma(Long id) {
        Optional<Idioma> optionalBook = idiomaRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    public void deleteIdioma(Long id) {
    	idiomaRepository.deleteById(id);
    }
}