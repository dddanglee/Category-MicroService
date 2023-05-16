package com.example.catagoryservice.controller;

import com.example.catagoryservice.repository.CatalogEntity;
import com.example.catagoryservice.service.CatalogService;
import com.example.catagoryservice.vo.ResponseCatalog;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/catalog-service")
@Slf4j
public class CatalogController {


    Environment env;
    CatalogService catalogService;

    @Autowired
    public CatalogController(Environment env, CatalogService catalogService) {
        this.env = env;
        this.catalogService = catalogService;
    }

    @GetMapping("/health_check")
    public String Status(){
        return "it's working. on Port "+env.getProperty("local.server.port");
    }



    @GetMapping("/catalogs")
    public ResponseEntity<List<ResponseCatalog>> getUsers(){
        Iterable<CatalogEntity> catalogList = catalogService.getAllCataglogs();

        List<ResponseCatalog> result = new ArrayList<>();

        catalogList.forEach(v->{
            result.add(new ModelMapper().map(v,ResponseCatalog.class));
        });

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
