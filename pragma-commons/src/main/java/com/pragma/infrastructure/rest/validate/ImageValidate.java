package com.pragma.infrastructure.rest.validate;

import org.springframework.web.multipart.MultipartFile;

import com.pragma.infrastructure.rest.dto.ImageMongoDbDto;
import com.pragma.infrastructure.rest.dto.ImageMysqlDto;

import static com.pragma.infrastructure.util.Pragma.file;

import java.util.Map;

public class ImageValidate {
	
	public static ImageMongoDbDto fileImageMongoDb(MultipartFile file) {
		Map<String, String> response = file(file);
		return new ImageMongoDbDto(null, response.get("filename"), response.get("contentType"), response.get("image"));
	}
	
	public static ImageMysqlDto fileImageMysql(MultipartFile file) {
		Map<String, String> response = file(file);
		return new ImageMysqlDto(0L, response.get("filename"), response.get("contentType"), response.get("image"));
	}	
}
