package com.pragma.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Image {
	
	private String _id;
	private String filename;
	private String contentType;
	private String image;
}
