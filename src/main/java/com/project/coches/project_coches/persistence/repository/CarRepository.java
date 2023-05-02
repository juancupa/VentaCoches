package com.project.coches.project_coches.persistence.repository;

import com.project.coches.project_coches.domain.dto.CarDto;
import com.project.coches.project_coches.domain.repository.ICarRepository;
import com.project.coches.project_coches.persistence.crud.ICarCrudRepository;
import com.project.coches.project_coches.persistence.mapper.ICarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CarRepository implements ICarRepository {

    private final ICarCrudRepository iCarCrudRepository;
    private final ICarMapper iCarMapper;
    @Override
    public List<CarDto> getAll() {

        return iCarMapper.toCarsDto(iCarCrudRepository.findAll());
    }

    @Override
    public List<CarDto> getByIdBrandCar(Integer idBrandCar) {

        return iCarMapper.toCarsDto(iCarCrudRepository.findAllByBrandCarId(idBrandCar));
    }

    @Override
    public List<CarDto> getCartByPriceLessThan(Double idCar) {

        return iCarMapper.toCarsDto(iCarCrudRepository.findAllByPriceLessThanEqualOrderByPriceAsc(idCar));
    }

    @Override
    public Optional<CarDto> getCar(Integer idCar) {

        return  iCarCrudRepository.findById(idCar)
                .map(iCarMapper :: toCarDto);
    }

    @Override
    public CarDto save(CarDto newCar) {

        return iCarMapper.toCarDto(iCarCrudRepository.save(iCarMapper.toCarEntity(newCar)));
    }

    @Override
    public void delete(Integer idCar) {
        iCarCrudRepository.deleteById(idCar);

    }
}
