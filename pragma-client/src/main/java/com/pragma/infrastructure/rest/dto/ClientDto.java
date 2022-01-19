package com.pragma.infrastructure.rest.dto;

import com.pragma.domain.TypeDocument;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientDto {
	
	private Long id;
	private String name;
	private String subname;
	private TypeDocument type;
	private Long document;
	private Integer age;
	private String cityBirth;
	
	private Long idImageMysql;
	private String idImageMongoDB;
}
