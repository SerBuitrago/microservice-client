package com.pragma.application.handler;

import com.pragma.domain.model.Client;
import com.pragma.domain.model.TypeDocument;
import com.pragma.domain.repository.IClientRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ClientFindByTypeAndDocumentHandler {
	
	private final IClientRepository clientRepository;
	
	public Client findByTypeAndDocument(TypeDocument typeDocument, Long document) {
		return clientRepository.findByTypeAndDocument(typeDocument, document);
	}
}
