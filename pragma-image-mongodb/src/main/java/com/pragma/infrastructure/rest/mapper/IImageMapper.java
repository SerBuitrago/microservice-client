package com.pragma.infrastructure.rest.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.pragma.domain.Image;
import com.pragma.infrastructure.rest.dto.ImageMongoDbDto;

@Mapper(componentModel = "spring")
public interface IImageMapper {

	ImageMongoDbDto toDto(Image image);

	List<ImageMongoDbDto> toDtoList(List<Image> images);

	Image toEntity(ImageMongoDbDto imageMongoDbDto);

	List<Image> toEntityList(List<ImageMongoDbDto> imageMongoDbDtos);
}
