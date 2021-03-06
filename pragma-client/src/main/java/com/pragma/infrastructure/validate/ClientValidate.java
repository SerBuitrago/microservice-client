
package com.pragma.infrastructure.validate;

import com.pragma.infrastructure.exception.PragmaException;
import com.pragma.infrastructure.rest.dto.ClientDto;

import static com.pragma.infrastructure.util.Pragma.isString;
import static com.pragma.infrastructure.util.Pragma.isLong;
import static com.pragma.infrastructure.util.Pragma.isInteger;

public class ClientValidate {
	public static ClientDto save(ClientDto clientDto){
		if(clientDto == null)
			throw new PragmaException("No se ha validado el cliente.");
		if(!isString(clientDto.getName()))
			throw new PragmaException("El nombre del cliente es obligatorio.");
		if(!isString(clientDto.getSubname()))
			throw new PragmaException("El apellido del cliente es obligatorio.");
		if(!isString(clientDto.getCityBirth()))
			throw new PragmaException("La ciudad de nacimiento del cliente es obligatorio.");
		if(clientDto.getType() == null || !isString(clientDto.getType().name()))
			throw new PragmaException("El tipo de documento del cliente es obligatorio.");
		if(!isLong(clientDto.getDocument()))
			throw new PragmaException("El documento del cliente es obligatorio.");
		if(!isInteger(clientDto.getAge()))
			throw new PragmaException("El edad del cliente es obligatorio.");
		if(clientDto.getAge() < 18)
			throw new PragmaException("La edad minima del cliente es 18 años.");
		if(clientDto.getAge() >= 100)
			throw new PragmaException("La edad maxima del cliente es 100 años.");
		return clientDto;
	}
	
	public static ClientDto update(ClientDto clientDto){
		clientDto = save(clientDto);
		if(!isLong(clientDto.getId()))
			throw new PragmaException("El id del cliente es obligatorio.");
		return clientDto;
	}
}
