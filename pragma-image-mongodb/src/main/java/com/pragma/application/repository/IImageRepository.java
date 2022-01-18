package com.pragma.application.repository;

import java.util.List;

import com.pragma.domain.Image;

public interface IImageRepository {
	
	Image findById(String _id);
	
	List<Image> findAll();
	
	<T> Image save(T file);
	
	<T> Image update(String _id, T file);
	
	boolean deleteById(String _id);
}
