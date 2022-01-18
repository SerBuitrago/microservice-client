package com.pragma.infrastructure.persistence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pragma.application.repository.IImageRepository;
import com.pragma.domain.Image;
import com.pragma.infrastructure.exception.PragmaException;
import com.pragma.infrastructure.persistence.entity.ImageEntity;
import com.pragma.infrastructure.persistence.mapper.IImageEntityMapper;
import com.pragma.infrastructure.persistence.repository.IImageEntityRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ImageEntityService implements IImageRepository {

	private final IImageEntityRepository iImageEntityRepository;
	private final IImageEntityMapper iImageEntityMapper;

	@Override
	public Image findById(String _id) {
		Optional<ImageEntity> optional = iImageEntityRepository.findById(_id);
		return iImageEntityMapper.toDomain(optional
				.orElseThrow(() -> new PragmaException("No se encontrado ninguna imagen con el id " + _id + ".")));
	}

	@Override
	public List<Image> findAll() {
		return iImageEntityMapper.toDomainList(iImageEntityRepository.findAll());
	}

	@Override
	public <T> Image save(Image image, T file) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Image update(Image image, T file) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(String _id) {
		findById(_id);
		iImageEntityRepository.deleteById(_id);
		return true;
	}
}
