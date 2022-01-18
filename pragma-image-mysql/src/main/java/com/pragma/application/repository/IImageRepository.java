package com.pragma.application.repository;

import java.util.List;

import com.pragma.domain.Image;

public interface IImageRepository {
	
	Image findById(Long id);
	
	List<Image> findAll();
	
	<T> Image save(T file);
	
	<T> Image update(Long id, T file);
	
	boolean deleteById(Long id);
}
