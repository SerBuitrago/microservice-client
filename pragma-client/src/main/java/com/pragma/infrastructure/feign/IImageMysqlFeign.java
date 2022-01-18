package com.pragma.infrastructure.feign;

import static com.pragma.infrastructure.util.PragmaVariable.ENDPOINT_CONTROLLER_IMAGE_MYSQL_METHOD_DELETE_BY_ID;
import static com.pragma.infrastructure.util.PragmaVariable.ENDPOINT_CONTROLLER_IMAGE_MYSQL_METHOD_SAVE;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.pragma.infrastructure.rest.dto.ImageMysqlDto;

@FeignClient(name = "pragma-image-mysql")
@RequestMapping("/api/image/mysql")
public interface IImageMysqlFeign {

	@PostMapping(value = ENDPOINT_CONTROLLER_IMAGE_MYSQL_METHOD_SAVE)
	ImageMysqlDto save(@RequestParam("fileMysql") MultipartFile multipartFile);

	@DeleteMapping(value = ENDPOINT_CONTROLLER_IMAGE_MYSQL_METHOD_DELETE_BY_ID)
	Boolean deleteById(@PathVariable("id") Long id);
}
