package com.pragma.application.service;

import java.util.List;

import com.pragma.application.repository.IImageRepository;
import com.pragma.domain.Image;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ImageService implements IImageRepository {

	private final IImageRepository iImageRepository;

	@Override
	public Image findById(String _id) {
		return iImageRepository.findById(_id);
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
	public <T> Image update(T file) {
		return iImageRepository.update(file);
	}

	@Override
	public boolean deleteById(String _id) {
		return iImageRepository.deleteById(_id);
	}
}
