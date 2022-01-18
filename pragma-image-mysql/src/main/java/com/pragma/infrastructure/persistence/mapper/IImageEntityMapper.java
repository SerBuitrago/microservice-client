package com.pragma.infrastructure.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.pragma.domain.Image;
import com.pragma.infrastructure.persistence.entity.ImageEntity;

@Mapper(componentModel = "spring")
public interface IImageEntityMapper {

	Image toDomain(ImageEntity clientEntity);

	List<Image> toDomainList(List<ImageEntity> clientEntities);

	ImageEntity toEntity(Image client);

	List<ImageEntity> toEntityList(List<Image> images);
}
