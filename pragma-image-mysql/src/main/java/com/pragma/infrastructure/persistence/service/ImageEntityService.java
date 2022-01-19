package com.pragma.infrastructure.persistence.service;

import static com.pragma.infrastructure.rest.validate.ImageValidate.fileImageMysql;

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

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ImageEntityService implements IImageRepository {

	private final IImageEntityRepository iImageEntityRepository;
	private final IImageEntityMapper iImageEntityMapper;
	private final IImageMapper iImageMapper;

	@Override
	public Image findById(Long id) {
		Optional<ImageEntity> optional = iImageEntityRepository.findById(id);
		return iImageEntityMapper.toDomain(optional
				.orElseThrow(() -> new PragmaException("No se encontrado ninguna imagen con el id " + id + ".")));
	}

	@Override
	public List<Image> findAll() {
		return iImageEntityMapper.toDomainList(iImageEntityRepository.findAll());
	}

	@Override
	public <T> Image save(T file) {
		Image image = iImageMapper.toEntity(fileImageMysql((MultipartFile) file));
		return iImageEntityMapper.toDomain(iImageEntityRepository.save(iImageEntityMapper.toEntity(image)));
	}

	@Override
	public <T> Image update(Long id, T file) {
		Image image = iImageMapper.toEntity(fileImageMysql(id, (MultipartFile) file));
		findById(id);
		return iImageEntityMapper.toDomain(iImageEntityRepository.save(iImageEntityMapper.toEntity(image)));
	}

	@Override
	public boolean deleteById(Long id) {
		System.out.println("Service Image: Eliminado "+id);
		findById(id);
		iImageEntityRepository.deleteById(id);
		return true;
	}
}
