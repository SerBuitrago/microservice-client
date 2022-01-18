
package com.pragma.infrastructure.rest.validate;

import com.pragma.infrastructure.exception.PragmaException;
import com.pragma.infrastructure.rest.dto.ClientDto;

import static com.pragma.infrastructure.util.Pragma.isString;
import static com.pragma.infrastructure.util.Pragma.isLong;
import static com.pragma.infrastructure.util.Pragma.isInteger;

public class ClientValidate {
	public static <T> ClientDto<T> save(ClientDto<T> clientDto){
		if(clientDto == null)
			throw new PragmaException("No se ha validado el cliente.");
		if(!isString(clientDto.getName()))
			throw new PragmaException("El nombre del cliente es obligatorio.");
		if(!isString(clientDto.getSubname()))
			throw new PragmaException("El apellido del cliente es obligatorio.");
		if(!isString(clientDto.getCityBirth()))
			throw new PragmaException("La ciudad de nacimiento del cliente es obligatorio.");
		Enum<?> valueEnum = (Enum<?>) clientDto.getType();
		if(valueEnum == null || !isString(valueEnum.name()))
			throw new PragmaException("El tipo de documento del cliente es obligatorio.");
		if(!isLong(clientDto.getDocument()))
			throw new PragmaException("El documento del cliente es obligatorio.");
		if(!isInteger(clientDto.getAge()))
			throw new PragmaException("El edad del cliente es obligatorio.");
		if(clientDto.getAge() < 18)
			throw new PragmaException("La edad minima del cliente es 18 años.");
		return clientDto;
	}
	
	public static <T> ClientDto<T> update(ClientDto<T> clientDto){
		clientDto = save(clientDto);
		if(!isLong(clientDto.getId()))
			throw new PragmaException("El id del cliente es obligatorio.");
		return clientDto;
	}
}
