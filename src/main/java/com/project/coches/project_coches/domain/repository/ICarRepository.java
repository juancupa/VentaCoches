package com.project.coches.project_coches.domain.repository;

import com.project.coches.project_coches.domain.dto.BrandCarDto;
import com.project.coches.project_coches.domain.dto.CarDto;

import java.util.List;
import java.util.Optional;


public interface ICarRepository {



    List<CarDto> getAll();
    List<CarDto> getByIdBrandCar(Integer idCar);
    List<CarDto> getCartByPriceLessThan(Double idCar);

    Optional<CarDto> getCar(Integer id);
    CarDto save(CarDto newCar);
    void delete (Integer idCar);
}
