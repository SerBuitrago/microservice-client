package com.pragma.application.repository;

import java.util.List;

import com.pragma.domain.Image;

public interface IImageRepository {
	
	Image findById(String _id);
	
	List<Image> findAll();
	
	<T> Image save(Image image, T file);
	
	<T> Image update(Image image, T file);
	
	boolean deleteById(String _id);
}
