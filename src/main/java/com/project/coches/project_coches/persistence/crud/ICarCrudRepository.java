package com.project.coches.project_coches.persistence.crud;

import com.project.coches.project_coches.persistence.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICarCrudRepository  extends JpaRepository<CarEntity, Integer> {


    List<CarEntity> findAllByBrandCarId(Integer id);
    List<CarEntity> findAllByPriceLessThanEqualOrderByPriceAsc(Double price);
}
