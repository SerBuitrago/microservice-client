package com.pragma.infrastructure.feign;

import static com.pragma.infrastructure.util.PragmaVariable.ENDPOINT_CONTROLLER_IMAGE_MONGODB;
import static com.pragma.infrastructure.util.PragmaVariable.ENDPOINT_CONTROLLER_IMAGE_MONGODB_METHOD_FIND_BY_ID;
import static com.pragma.infrastructure.util.PragmaVariable.ENDPOINT_CONTROLLER_IMAGE_MONGODB_METHOD_DELETE_BY_ID;
import static com.pragma.infrastructure.util.PragmaVariable.ENDPOINT_CONTROLLER_IMAGE_MONGODB_METHOD_SAVE;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.pragma.infrastructure.rest.dto.ImageMongoDbDto;

@FeignClient(name = "pragma-image-mongodb")
@RequestMapping(ENDPOINT_CONTROLLER_IMAGE_MONGODB)
public interface IImageMongoDbFeign {
	
	@GetMapping(value = ENDPOINT_CONTROLLER_IMAGE_MONGODB_METHOD_FIND_BY_ID)
	ImageMongoDbDto findById(@PathVariable("id") String id);
	
	@PostMapping(value = ENDPOINT_CONTROLLER_IMAGE_MONGODB_METHOD_SAVE)
	ImageMongoDbDto save(@RequestParam("fileMongoDB") MultipartFile multipartFile);
	
	@DeleteMapping(value = ENDPOINT_CONTROLLER_IMAGE_MONGODB_METHOD_DELETE_BY_ID)
	Boolean deleteById(@PathVariable("_id") String _id) ;
}
