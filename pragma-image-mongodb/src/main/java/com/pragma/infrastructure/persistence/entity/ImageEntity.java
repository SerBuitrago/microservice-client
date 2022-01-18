package com.pragma.infrastructure.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "image")
public class ImageEntity {
	
	@Id
	private Long id;
	
	@Column(name = "content_type", nullable = false)
	private String contentType;
	
	private String filename;
	
	@Lob
	private String image;
}
