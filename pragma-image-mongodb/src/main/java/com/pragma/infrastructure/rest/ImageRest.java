package com.pragma.infrastructure.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pragma.application.service.ImageService;
import com.pragma.infrastructure.rest.dto.ImageMysqlDto;
import com.pragma.infrastructure.rest.mapper.IImageMapper;

import static com.pragma.infrastructure.util.PragmaVariable.ENDPOINT_CONTROLLER_IMAGE_MONGODB;
import static com.pragma.infrastructure.util.PragmaVariable.ENDPOINT_CONTROLLER_IMAGE_MONGODB_METHOD_FIND_BY_ID;;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(ENDPOINT_CONTROLLER_IMAGE_MONGODB)
public class ImageRest {

	@Autowired
	ImageService imageService;
	
	@Autowired
	IImageMapper iImageMapper;

	@GetMapping(value = ENDPOINT_CONTROLLER_IMAGE_MONGODB_METHOD_FIND_BY_ID)
	public ResponseEntity<ImageMysqlDto> findById(String _id) {
		return ResponseEntity.status(HttpStatus.OK).body(iImageMapper.toDto(imageService.findById(_id)));
	}
}
