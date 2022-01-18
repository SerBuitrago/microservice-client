package com.pragma.infrastructure.util;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.pragma.infrastructure.exception.PragmaException;

public class Pragma {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Pragma.class);
	
	public static boolean isString(String string) {
		return string != null && string.trim().length() > 0;
	}
	
	public static boolean isInteger(Integer value) {
		return value != null && value > 0;
	}
	
	public static boolean isLong(Long value) {
		return value != null && value > 0;
	}
	
	public static Map<String, String> file(MultipartFile file){
		if (file == null || file.isEmpty())
			throw new PragmaException("No se ha recibido la imagen.");
		Map<String, String> response = new HashMap<>();
		try {
			byte[] bytes = file.getBytes();
			response.put("contentType", file.getContentType());
			response.put("filename", file.getOriginalFilename());
			response.put("size", String.valueOf(file.getSize()));
			response.put("image", Base64.getEncoder().encodeToString(bytes));
		} catch (IOException e) {
			LOGGER.error("file(MultipartFile file)", e);
		}
		return response;
	}
}
