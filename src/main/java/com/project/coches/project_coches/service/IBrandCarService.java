package com.project.coches.project_coches.service;

import com.project.coches.project_coches.domain.pojos.BrandCarPojo;

import java.util.List;
import java.util.Optional;

public interface IBrandCarService {

    List<BrandCarPojo> getAll();

    Optional<BrandCarPojo> getBrandCar(Integer id);

    BrandCarPojo save(BrandCarPojo newBrandCar);

    BrandCarPojo update (BrandCarPojo newBrandCar);

   // Optional<BrandCarPojo> update(BrandCarPojo newBrandCar);

    boolean delete(Integer idBrandCar);



}
