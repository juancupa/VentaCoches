package com.project.coches.project_coches.domain.useCase;

import com.project.coches.project_coches.domain.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface ICarService {

    List<CarDto> getAll();
    List<CarDto> getByIdBrandCar(Integer idBrandCar);
    List<CarDto> getCartByPriceLessThan(Double idCar);

    Optional<CarDto> getCar(Integer id);
    CarDto save(CarDto newCar);
    boolean delete (Integer idCar);

}
