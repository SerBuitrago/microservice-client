package com.pragma.infrastructure.rest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientDto<T> {
	
	private Long id;
	private String name;
	private String subname;
	private T type;
	private Long document;
	private Integer age;
	private String cityBirth;
	
	private Long idImageMysql;
	private String idImageMongoDB;
}
