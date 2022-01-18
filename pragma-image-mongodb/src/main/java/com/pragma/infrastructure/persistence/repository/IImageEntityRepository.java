package com.pragma.infrastructure.persistence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pragma.infrastructure.persistence.entity.ImageEntity;

@Repository
public interface IImageEntityRepository extends MongoRepository<ImageEntity, String>{

}
