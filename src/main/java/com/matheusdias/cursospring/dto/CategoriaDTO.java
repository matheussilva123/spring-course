package com.matheusdias.cursospring.dto;

import com.matheusdias.cursospring.domain.Categoria;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CategoriaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min=5, max= 80, message = "O tamanho deve ser entre 5 e 80 caracteres")
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

    public String getName() {
        return name;
    }

    public void setNome(String nome) {
        this.name = name;
    }

}
