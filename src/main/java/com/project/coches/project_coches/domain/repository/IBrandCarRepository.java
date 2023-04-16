package com.project.coches.project_coches.domain.repository;

import com.project.coches.project_coches.domain.pojos.BrandCarPojo;

import java.util.List;
import java.util.Optional;

public interface IBrandCarRepository {

    /**
     * devuelvr todas las marcas de coches
     * @return Lista con marcas de coches
     */

    List<BrandCarPojo> getAll();
    /**Devuleve una marca de coche dada su id
     * @param id Id  de marca coches
     * @return Option del maarca coche encontrado
     *
     */
    Optional<BrandCarPojo> getBrandCar(Integer id);

    /**
     * Gardar una nueva marca coche
     * @param newBrandCar Marca coche a guardar
     * @return Marca coche guarda
     */
    BrandCarPojo save(BrandCarPojo newBrandCar);

    /**
     * Elimina uan marca coche dad de id
     * @param idBrandCar Id del marca coche a eliminar
     */
    void delete (Integer idBrandCar);

}
