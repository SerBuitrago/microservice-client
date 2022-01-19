package com.pragma.infrastructure.feign;

import static com.pragma.infrastructure.util.PragmaVariable.ENDPOINT_CONTROLLER_IMAGE_MONGODB;
import static com.pragma.infrastructure.util.PragmaVariable.ENDPOINT_CONTROLLER_IMAGE_MONGODB_METHOD_FIND_BY_ID;
import static com.pragma.infrastructure.util.PragmaVariable.ENDPOINT_CONTROLLER_IMAGE_MONGODB_METHOD_DELETE_BY_ID;
import static com.pragma.infrastructure.util.PragmaVariable.ENDPOINT_CONTROLLER_IMAGE_MONGODB_METHOD_SAVE;
import static com.pragma.infrastructure.util.PragmaVariable.MICROSERVICE_IMAGE_MONGODB;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.pragma.infrastructure.config.PragmaFeignConfig;
import com.pragma.infrastructure.rest.dto.ImageMongoDbDto;

@FeignClient(name = MICROSERVICE_IMAGE_MONGODB, configuration = {PragmaFeignConfig.class})
@RequestMapping(ENDPOINT_CONTROLLER_IMAGE_MONGODB)
public interface IImageMongoDbFeign {
	
	@GetMapping(value = ENDPOINT_CONTROLLER_IMAGE_MONGODB_METHOD_FIND_BY_ID)
	ImageMongoDbDto findById(@PathVariable("id") String id);
	
	@PostMapping(value = ENDPOINT_CONTROLLER_IMAGE_MONGODB_METHOD_SAVE, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	ImageMongoDbDto save(@RequestPart("file") MultipartFile multipartFile);
	
	@DeleteMapping(value = ENDPOINT_CONTROLLER_IMAGE_MONGODB_METHOD_DELETE_BY_ID)
	Boolean deleteById(@PathVariable("id") String _id) ;
}
