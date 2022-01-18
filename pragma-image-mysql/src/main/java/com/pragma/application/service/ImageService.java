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
	public Image findByClient(Long idClient) {
		return iImageRepository.findByClient(idClient);
	}

	@Override
	public List<Image> findAll() {
		return iImageRepository.findAll();
	}

	@Override
	public <T> Image save(Image image, T file) {
		return iImageRepository.save(image, file);
	}

	@Override
	public <T> Image update(Image image, T file) {
		return iImageRepository.update(image, file);
	}

	@Override
	public boolean deleteById(Long id) {
		return iImageRepository.deleteById(id);
	}
}
