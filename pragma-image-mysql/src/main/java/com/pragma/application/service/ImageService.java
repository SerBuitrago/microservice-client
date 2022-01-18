package com.pragma.application.service;

import java.util.List;

import com.pragma.application.repository.IImageRepository;
import com.pragma.domain.Image;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ImageService implements IImageRepository {

	private final IImageRepository iImageRepository;

	@Override
	public Image findById(Long id) {
		return iImageRepository.findById(id);
	}

	@Override
	public List<Image> findAll() {
		return iImageRepository.findAll();
	}

	@Override
	public <T> Image save(T file) {
		return iImageRepository.save(file);
	}

	@Override
	public <T> Image update(Long id, T file) {
		return iImageRepository.update(id, file);
	}

	@Override
	public boolean deleteById(Long id) {
		return iImageRepository.deleteById(id);
	}
}
