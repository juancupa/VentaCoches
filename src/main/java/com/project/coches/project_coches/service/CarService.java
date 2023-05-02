package com.project.coches.project_coches.service;

import com.project.coches.project_coches.domain.dto.CarDto;
import com.project.coches.project_coches.domain.repository.ICarRepository;
import com.project.coches.project_coches.domain.useCase.ICarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CarService  implements ICarService {

    private  final ICarRepository iCarRepository;
    @Override
    public List<CarDto> getAll() {
        return  iCarRepository.getAll();
    }

    @Override
    public List<CarDto> getByIdBrandCar(Integer idBrandCar) {
        return iCarRepository.getByIdBrandCar(idBrandCar) ;
    }

    @Override
    public List<CarDto> getCartByPriceLessThan(Double idCar) {
        return iCarRepository.getCartByPriceLessThan(idCar);
    }

    @Override
    public Optional<CarDto> getCar(Integer id) {
        return iCarRepository.getCar(id);
    }

    @Override
    public CarDto save(CarDto newCar) {
        return  iCarRepository.save(newCar);
    }

    @Override
    public boolean delete(Integer idCar) {

        if (iCarRepository.getCar(idCar).isEmpty()){
            return false;
        }
        iCarRepository.delete(idCar);
        return true;

    }
}
