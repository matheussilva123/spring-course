package com.matheusdias.cursospring.dto;

import com.matheusdias.cursospring.domain.Cliente;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class ClienteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 catacteres")
    private String name;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Email(message = "Email Invalido")
    private String email;

    public ClienteDTO() {

    }

    public ClienteDTO(Cliente obj) {
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
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

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
