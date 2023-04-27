package com.project.coches.project_coches.service;

import com.project.coches.project_coches.domain.dto.BrandCarDto;

import java.util.List;
import java.util.Optional;

public interface IBrandCarService {

    List<BrandCarDto> getAll();

    Optional<BrandCarDto> getBrandCar(Integer id);

    BrandCarDto save(BrandCarDto newBrandCar);

    BrandCarDto update (BrandCarDto newBrandCar);

   // Optional<BrandCarDto> update(BrandCarDto newBrandCar);

    boolean delete(Integer idBrandCar);


    Optional<BrandCarDto> update01(BrandCarDto newBrandCar);



}
