package com.pragma.domain.repository;

import java.util.List;

import com.pragma.domain.model.Client;

public interface IClientRepository {

	Client findById(Long id);

	Client findByTypeAndDocument(String type, Long document);

	List<Client> findAll();

	List<Client> findByType(String type);

	List<Client> findByHigherOrEqualsAge(Integer age);

	<A> Client save(Client client, A file);

	<A> Client update(Client client, A file);

	boolean deleteById(Long id);
}
