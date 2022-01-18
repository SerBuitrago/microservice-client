package com.pragma.infrastructure.rest.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.pragma.domain.Image;
import com.pragma.infrastructure.rest.dto.ClientDto;
import com.pragma.infrastructure.rest.dto.ImageMysqlDto;

@Mapper(componentModel = "spring")
public interface IImageMapper {

	ImageMysqlDto toDto(Image client);

	List<ImageMysqlDto> toDtoList(List<Image> clients);

	Image toEntity(ImageMysqlDto clientDto);

	List<Image> toEntityList(List<ImageMysqlDto> clientDtos);
}
