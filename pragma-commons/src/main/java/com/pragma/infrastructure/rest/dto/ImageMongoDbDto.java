package com.pragma.infrastructure.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ImageMongoDbDto {
	private String _id;
	private String filename;
	private String contentType;
	private String image;
}
