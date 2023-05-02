package com.project.coches.project_coches.persistence.repository;

import com.project.coches.project_coches.domain.dto.BrandCarDto;
import com.project.coches.project_coches.domain.repository.IBrandCarRepository;
import com.project.coches.project_coches.persistence.crud.IBrandCarCrudRepository;
import com.project.coches.project_coches.persistence.entity.BrandCarEntity;
import com.project.coches.project_coches.persistence.mapper.IBrandCarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repositorio de marca coche
 */
@RequiredArgsConstructor// crea el construcor con el
@Repository
public class BrandCarRepository  implements IBrandCarRepository {

    /**
     * Crud de marca coche
     */
    private  final IBrandCarCrudRepository iBrandCarCrudRepository;

    /**
     * Mappe4 de marca coche
     */
    private final IBrandCarMapper iBrandCarMapper;

/*
    public BrandCarRepository(IBrandCarCrudRepository iBrandCarCrudRepository, IBrandCarMapper iBrandCarMapper) {
        this.iBrandCarCrudRepository = iBrandCarCrudRepository;
        this.iBrandCarMapper = iBrandCarMapper;
    }*/

    @Override
    public List<BrandCarDto> getAll() {
        return iBrandCarMapper.toMarcaCochePojo(iBrandCarCrudRepository.findAll());

    }

    @Override
    public Optional<BrandCarDto> getBrandCar(Integer id) {

        return iBrandCarCrudRepository.findById(id)
                .map(iBrandCarMapper :: toMarcaCochePojo);
    }

    @Override
    public BrandCarDto save(BrandCarDto newBrandCar) {

        BrandCarEntity brandCarEntity = iBrandCarMapper.toMarcaCocheEntity(newBrandCar);
        return  iBrandCarMapper.toMarcaCochePojo(iBrandCarCrudRepository.save(brandCarEntity));
    }

    @Override
    public void delete(Integer idBrandCar) {
        iBrandCarCrudRepository.deleteById(idBrandCar);

    }
}
