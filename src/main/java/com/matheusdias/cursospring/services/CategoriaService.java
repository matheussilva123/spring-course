package com.matheusdias.cursospring.services;

import com.matheusdias.cursospring.domain.Categoria;
import com.matheusdias.cursospring.repositories.CategoriaRepository;
import com.matheusdias.cursospring.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria find(Integer id) {
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }

    public Categoria insert (Categoria obj){
        obj.setId(null);
        return repo.save(obj);
    }

}
