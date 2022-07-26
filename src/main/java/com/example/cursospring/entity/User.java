package com.example.cursospring.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class User implements Serializable{

	private static final long serialVersionUID = 7160385895434188773L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50)
	private String name;
	
	@Column(name="contrasenia", nullable=false, length=50, unique=true)
	private String password;
	
	private String email;
	private Boolean enable;

	private String cedula;
	private  String imagenPath;
	@Transient
	private  String imagenUrl;
}
