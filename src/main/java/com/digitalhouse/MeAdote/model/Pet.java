package com.digitalhouse.MeAdote.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "pets")
public class Pet implements BaseModel{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	@ManyToOne
	@JoinColumn(name="id_usuario", nullable=false)
	@JsonIgnore
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="id_especie")
	private Especie especie;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ImagemPet> imagensPet;
	
	@Column(length = 45, nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private Date data_nascimento;
	
	@Column(length = 1, nullable = false)
	private String sexo;
	
	@Column(length = 45, nullable = true)
	private String porte;
	
	@Column(nullable = true)
	private Float peso;
	
	@Column(length = 255, nullable = true)
	private String descricao;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_pet_desaparecido", referencedColumnName = "id")
	private PetDesaparecido petDesaparecido;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Match> matches;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Like> likes;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_adocao", referencedColumnName = "id")
	@JsonIgnore
	private Adocao adocao;

}