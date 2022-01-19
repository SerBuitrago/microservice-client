package com.pragma.infrastructure.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.pragma.domain.TypeDocument;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "client")
public class ClientEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	private String name;
	private String subname;
	
	@Enumerated(EnumType.STRING)
	private TypeDocument type;
	
	private Long document;
	private int age;
	
	@Column(name = "city_birth", nullable = false, length = 100)
	private String cityBirth;
	
	@Column(name = "id_image_mysql", nullable = true)
	private Long idImageMysql;
	
	@Column(name = "id_image_mongodb", nullable = true)
	private String idImageMongoDB;
}
