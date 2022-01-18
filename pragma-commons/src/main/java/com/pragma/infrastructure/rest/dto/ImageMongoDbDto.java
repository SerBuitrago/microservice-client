package com.pragma.infrastructure.rest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageMongoDbDto {
	private String _id;
	private String filename;
	private String contentType;
	private String image;
}
