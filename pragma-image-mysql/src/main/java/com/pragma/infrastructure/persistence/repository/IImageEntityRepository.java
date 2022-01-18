package com.pragma.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pragma.infrastructure.persistence.entity.ImageEntity;

@Repository
public interface IImageEntityRepository extends JpaRepository<ImageEntity, Long>{

}
