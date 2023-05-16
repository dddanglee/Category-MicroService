package com.example.catagoryservice.service;

import com.example.catagoryservice.repository.CatalogEntity;

public interface CatalogService {
    Iterable<CatalogEntity> getAllCataglogs();
}
