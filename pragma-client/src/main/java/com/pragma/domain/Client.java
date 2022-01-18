package com.pragma.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {
	
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
