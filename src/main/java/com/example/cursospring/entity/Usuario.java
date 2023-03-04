package com.example.cursospring.entity;

import com.example.cursospring.security.enums.RoleEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.FetchMode;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue
    private Integer id_usuarios;

    @NonNull
    private String usuario;
    private String contra;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cedula", referencedColumnName = "cedula")
    private Persona persona;



    public Usuario(Integer id_usuarios, @NonNull String usuario, String contra, Persona persona) {
        this.id_usuarios = id_usuarios;
        this.usuario = usuario;
        this.contra = contra;
        this.persona = persona;
    }
}
