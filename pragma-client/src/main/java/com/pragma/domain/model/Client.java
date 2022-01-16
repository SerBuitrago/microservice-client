package com.pragma.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Client {
	
	private Long id;
	private String name;
	private String subname;
	private TypeDocument type;
	private Long document;
	private Integer age;
	private String cityBirth;
}
