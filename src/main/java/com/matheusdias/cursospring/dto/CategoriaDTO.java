package com.matheusdias.cursospring.dto;

import com.matheusdias.cursospring.domain.Categoria;

import java.io.Serializable;

public class CategoriaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;

    public CategoriaDTO() {

    }

    public CategoriaDTO(Categoria obj){
        id = obj.getId();
        name = obj.getName();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return name;
    }

    public void setNome(String nome) {
        this.name = name;
    }

}
