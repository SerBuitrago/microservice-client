package com.pragma.infrastructure.rest.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.pragma.domain.Image;
import com.pragma.infrastructure.rest.dto.ImageMysqlDto;

@Mapper(componentModel = "spring")
public interface IImageMapper {

	ImageMysqlDto toDto(Image image);

	List<ImageMysqlDto> toDtoList(List<Image> images);

	Image toEntity(ImageMysqlDto imageMysqlDto);

	List<Image> toEntityList(List<ImageMysqlDto> imageMysqlDtos);
}
