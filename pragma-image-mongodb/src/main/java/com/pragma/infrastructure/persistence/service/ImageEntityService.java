package com.pragma.infrastructure.persistence.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pragma.application.repository.IImageRepository;
import com.pragma.domain.Image;
import com.pragma.infrastructure.exception.PragmaException;
import com.pragma.infrastructure.persistence.entity.ImageEntity;
import com.pragma.infrastructure.persistence.mapper.IImageEntityMapper;
import com.pragma.infrastructure.persistence.repository.IImageEntityRepository;
import com.pragma.infrastructure.rest.mapper.IImageMapper;

import static com.pragma.infrastructure.rest.validate.ImageValidate.fileImageMongoDb;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ImageEntityService implements IImageRepository {

	private final IImageEntityRepository iImageEntityRepository;
	private final IImageEntityMapper iImageEntityMapper;
	private final IImageMapper iImageMapper;

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
	public <T> Image save(T file) {
		Image image = iImageMapper.toEntity(fileImageMongoDb((MultipartFile) file));
		return iImageEntityMapper.toDomain(iImageEntityRepository.save(iImageEntityMapper.toEntity(image)));
	}

	@Override
	public <T> Image update(String _id, T file) {
		Image image = iImageMapper.toEntity(fileImageMongoDb(_id, (MultipartFile) file));
		findById(_id);
		return iImageEntityMapper.toDomain(iImageEntityRepository.save(iImageEntityMapper.toEntity(image)));
	}

	@Override
	public boolean deleteById(String _id) {
		findById(_id);
		iImageEntityRepository.deleteById(_id);
		return true;
	}
}
