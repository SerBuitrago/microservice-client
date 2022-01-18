package com.pragma.infrastructure.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pragma.domain.TypeDocument;
import com.pragma.infrastructure.persistence.entity.ClientEntity;

@Repository
public interface IClientEntityRepository extends JpaRepository<ClientEntity, Long>{
	
	ClientEntity findByTypeAndDocument(TypeDocument type, Long document);
	
	List<ClientEntity> findByType(TypeDocument type);
	
	@Query(nativeQuery = false, value = "SELECT c FROM ClientEntity c WHERE c.age >= :age")
	List<ClientEntity> findByHigherOrEqualsAge(@Param("age") int age);
}
