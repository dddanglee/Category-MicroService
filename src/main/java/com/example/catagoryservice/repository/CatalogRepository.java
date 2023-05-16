package com.example.catagoryservice.repository;

import org.springframework.data.repository.CrudRepository;

public interface CatalogRepository extends CrudRepository<CatalogEntity,Long> {
    CatalogEntity findByProductId(String productID);

}
