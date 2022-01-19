package com.pragma.application.repository;

import java.util.List;

import com.pragma.domain.Client;
import com.pragma.domain.TypeDocument;

public interface IClientRepository {

	Client findById(Long id);

	Client findByTypeAndDocument(TypeDocument type, Long document);

	List<Client> findAll();

	List<Client> findByType(TypeDocument type);

	List<Client> findByHigherOrEqualsAge(Integer age);

	<A> Client save(Client client, A file);

	<A> Client update(Client client);

	boolean deleteById(Long id);
}
